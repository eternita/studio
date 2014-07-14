/*
 * Copyright (c) 2013-2014, Neuro4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neuro4j.studio.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class UUIDMgr
{
    /**
     * The singleton instance.
     */

    private static UUIDMgr instance;

    /**
     * The random number generator.
     * Used for the UUID calculation.
     */

    private Random random;

    /**
     * The IP address of this host.
     * Used for the UUID calculation.
     */

    private byte[] ip;

    /**
     * Process identifier of the java process to distinguish among
     * concurrent processes on a single machine.
     * Used for the UUID calculation.
     */

    private long processID;

    /**
     * The counter for an improved resolution of the system clock.
     * Used for the UUID calculation.
     */

    private short counter;

    /**
     * The starting value for the counter.
     * Used for the UUID calculation.
     */

    private short startCounter;

    /**
     * The time when the last UUID was created.
     * Used for the UUID calculation.
     */

    private long lastTime;

    /**
     * The debug mode flag.
     * Used for the UUID calculation.
     */

    private boolean debugMode;

    /**
     * The initial counter state for the debug mode.
     * Used for the UUID calculation.
     */

    private int initialCount = 0;

    /**
     * The class initializer, creates a new instance.
     */

    static
    {
        instance = new UUIDMgr();
    }

    /*-----------------------------------------------------
                       instance methods
    -----------------------------------------------------*/

    /**
     * The private constructor.
     * 
     */

    private UUIDMgr()
    {
        // initialize the UUID generation stuff
        random = new Random();

        // the processID is used as a unique identifier for this java process
        processID = System.nanoTime();

        // init the time counter with a random number
        counter = (short) (random.nextInt() & 0xffff);
        startCounter = counter;

        lastTime = 0L;
        try
        {
            InetAddress host = InetAddress.getLocalHost();
            ip = host.getAddress();
        } catch (UnknownHostException ue)
        {
            // host address not available, just take random numbers
            ip = new byte[] { (byte) (random.nextInt() & 0xff),
                    (byte) (random.nextInt() & 0xff),
                    (byte) (random.nextInt() & 0xff),
                    (byte) (random.nextInt() & 0xff) };
        }

        // switch off debug mode
        debugMode = false;
        initialCount = 0;
    }

    /**
     * Returns the singleton instance of the UUID manager.
     * 
     * @return the UUID manager object
     * 
     */

    public static UUIDMgr getInstance()
    {
        return instance;
    }

    /*----------------------------------------------------------------
                   UUID generation methods
    ----------------------------------------------------------------*/

    /**
     * Creates a new UUID string that contains no type information.
     * 
     * @return the new UUID string
     * 
     */

    public String createUUIDString()
    {
        return createUUID(0);
    }

    /**
     * Switches the debug mode on or off. In the debug mode, the only
     * variable part of the UUID's is a counter. Therefore, we will get
     * the same sequence of UUID's on any machine at any time.
     * The counter can also be set to an initial value.
     * 
     * @param debug
     *        true to switch on debug mode, false to switch it off
     * 
     * @see #setInitialCount
     * 
     */

    public void setDebugMode(boolean debug)
    {
        debugMode = debug;
    }

    /**
     * Switches the debug mode on or off. In the debug mode, the UUID's are
     * created starting with an initial counter.
     * If the debug mode is switched off, the initial counter is ignored.
     * 
     * @param debugMode
     *        true to switch on debug mode
     * @param initialCount
     *        the inital count for ranges of UUID's
     * 
     */

    public void setDebugMode(boolean debugMode, int initialCount)
    {
        setDebugMode(debugMode);
        setInitialCount(initialCount);
    }

    /**
     * Sets the initial counter for the UUID's generated in debug mode.
     * 
     * @param counter
     *        the inital count for ranges of UUID's
     * 
     * @see #setDebugMode
     * 
     */

    public void setInitialCount(int counter)
    {
        this.initialCount = counter;
    }

    /*------------------------------------------------------
                     private helper methods
    ------------------------------------------------------*/

    /**
     * Creates a new UUID string. The ID consists of a class type code,
     * an IP address and process id of this server, the current system time,
     * a time resolution enhancement counter and a random number.
     * All components are encoded using the Base64 encoding scheme.
     * 
     * @param aTypeCode
     *        the type code to be encoded
     * @return the new UUID string
     */

    private String createUUID(int aTypeCode)
    {
        // byte array for the binary representation of the UUID
        byte[] array = new byte[18];

        // higher byte of class type code
        byte hiCode = (byte) ((aTypeCode >> 8) & 0xff);

        // lower byte of class type code
        byte loCode = (byte) (aTypeCode & 0xff);

        // type code higher part (7 bits)
        array[8] = hiCode;

        // type code lower part (8 bits)
        array[9] = loCode;

        // in debug mode UUID's are machine independent and created
        // always in the same sequence
        if (debugMode)
        {
            // unused in debug mode
            array[2] = 0;
            array[3] = 0;
            array[4] = 0;
            array[5] = 0;
            array[6] = 0;

            // unused in debug mode
            array[7] = (byte) 'B';
            array[0] = (byte) 'e';
            array[1] = (byte) 'e';
            array[10] = (byte) 'h';
            array[11] = (byte) 'i';
            array[12] = (byte) 'v';
            array[13] = (byte) 'e';

            // create a lock for changing the counter
            synchronized (this)
            {
                // in debug mode the only variable part is a 4-byte counter
                array[14] = (byte) ((initialCount >> 24) & 0xff);
                array[15] = (byte) ((initialCount >> 16) & 0xff);
                array[16] = (byte) ((initialCount >> 8) & 0xff);
                array[17] = (byte) (initialCount & 0xff);
                initialCount++;
            }
        }
        else
        {
            // IP address (32 bits)
            array[2] = ip[0];
            array[3] = ip[1];
            array[4] = ip[2];
            array[5] = ip[3];

            // processID number higher part
            array[14] = (byte) ((processID >> 8) & 0xff);

            // processID number lower part
            array[15] = (byte) (processID & 0xff);

            long time = 0L;

            short localCounter = 0;
            // random number (16 bits)
            int rand = 0;

            // create a lock for changing the counter
            synchronized (this)
            {
                // get the creation time of the UUID (48 bits)
                time = System.currentTimeMillis();
                if (time == lastTime)
                {
                    counter++;
                    if (counter == startCounter)
                    {
                        // we MUST wait until the system clock changes
                        do
                        {
                            // wait for 10 milliseconds
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ie) {
                            }

                            // now read time again
                            time = System.currentTimeMillis();

                        } while (lastTime == time);

                        lastTime = time;
                    }
                }
                else
                {
                    lastTime = time;
                    // init the counter
                    counter = (short) (random.nextInt() & 0xffff);
                    startCounter = counter;
                }

                localCounter = counter;
                rand = random.nextInt();
            }

            // time stamp (48 bits)
            array[10] = (byte) ((time >> 40) & 0xff);
            array[11] = (byte) ((time >> 32) & 0xff);
            array[16] = (byte) ((time >> 24) & 0xff);
            array[17] = (byte) ((time >> 16) & 0xff);
            array[13] = (byte) ((time >> 8) & 0xff);
            array[12] = (byte) (time & 0xff);

            // counter (16 bits)
            array[6] = (byte) ((localCounter >> 8) & 0xff);
            array[7] = (byte) (localCounter & 0xff);

            array[0] = (byte) ((rand >> 8) & 0xff);
            array[1] = (byte) (rand & 0xff);
        }

        // encode the array in Base64
        return encodeUUID(array);
    }

    /**
     * This method encodes the UUID byte array into a Base64 like UUID
     * encoded string. The resulting string will have a guaranteed length
     * of 24 characters.
     * 
     * @param array
     *        the binary representation of the UUID
     * 
     * @return the encoded string
     * 
     */

    private String encodeUUID(byte[] array)
    {
        return encode(array);
    }

    public final static char[] ENCRYPTION_TABLE =
    {
            // 0 1 2 3 4 5 6 7
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', // 0
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', // 1
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', // 2
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', // 3
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', // 4
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', // 5
            'w', 'x', 'y', 'z', '0', '1', '2', '3', // 6
            '4', '5', '6', '7', '8', '9', '.', '_' // 7
    };

    /**
     * A static array that maps ASCII code points to a 6-bit integer,
     * or -1 for an invalid code point.
     */
    protected final static byte[] dec_table =
    {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
            -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    };

    /**
     * Encodes <i>data</i> as a String using base64 like encoding. L
     * 
     * @param data
     *        The bytes that have to be encoded.
     * 
     * @return the encoded string.
     * 
     */
    public static String encode(byte[] data)
    {
        return new String(encodeAsByteArray(data));
    }

    /**
     * Encodes <i>data</i> as a byte array using base64 like encoding. The characters
     * 'A'-'Z', 'a'-'z', '0'-'9', '#', '_', and '=' in the output are mapped to
     * their ASCII code points. Line breaks in the output are represented as
     * CR LF (codes 13 and 10).
     * 
     * @param data
     *        The bytes that have to be encoded.
     * 
     * @return the encoded byte array.
     * 
     * @reviewed 08/29/99 Stefan Gloy
     */
    public static byte[] encodeAsByteArray(byte[] data)
    {
        int i = 0, j = 0;
        int len = data.length;
        int delta = len % 3;
        int outlen = ((len + 2) / 3) * 4 + (len == 0 ? 2 : 0);
        byte[] output = new byte[outlen];
        byte a, b, c;

        for (int count = len / 3; count > 0; count--)
        {
            a = data[i++];
            b = data[i++];
            c = data[i++];
            output[j++] = (byte) (ENCRYPTION_TABLE[(a >>> 2) & 0x3F]);
            output[j++] = (byte) (ENCRYPTION_TABLE[((a << 4) & 0x30) + ((b >>> 4) & 0x0F)]);
            output[j++] = (byte) (ENCRYPTION_TABLE[((b << 2) & 0x3C) + ((c >>> 6) & 0x03)]);
            output[j++] = (byte) (ENCRYPTION_TABLE[c & 0x3F]);
        }

        if (delta == 1)
        {
            a = data[i++];
            output[j++] = (byte) (ENCRYPTION_TABLE[(a >>> 2) & 0x3F]);
            output[j++] = (byte) (ENCRYPTION_TABLE[((a << 4) & 0x30)]);
            output[j++] = (byte) '=';
            output[j++] = (byte) '=';
        }
        else if (delta == 2)
        {
            a = data[i++];
            b = data[i++];
            output[j++] = (byte) (ENCRYPTION_TABLE[(a >>> 2) & 0x3F]);
            output[j++] = (byte) (ENCRYPTION_TABLE[((a << 4) & 0x30) + ((b >>> 4) & 0x0F)]);
            output[j++] = (byte) (ENCRYPTION_TABLE[((b << 2) & 0x3C)]);
            output[j++] = (byte) '=';
        }

        if (j != outlen)
        {
            throw new InternalError("Bug in UUIDCodec.java: incorrect length calculated for base64 output");
        }

        return output;
    }

    /**
     * Decodes a byte array containing UUID-encoded ASCII. Characters with
     * ASCII code points &lt;= 32 (this includes whitespace and newlines) are
     * ignored.
     * 
     * @param data
     *        The bytes that have to be decoded.
     * 
     * @return the decoded data.
     * @exception IllegalArgumentException
     *            if data contains invalid characters,
     *            i.e. not codes 0-32, 'A'-'Z', 'a'-'z', '#', '_'. or '=', or is
     *            incorrectly padded.
     * 
     */
    public static byte[] decode(byte[] data)
    {
        int padCount = 0;
        int i, len = data.length;
        int real_len = 0;

        for (i = len - 1; i >= 0; --i)
        {
            if (data[i] > ' ')
                real_len++;

            if (data[i] == 0x3D) // ASCII '='
                padCount++;
        }

        if (real_len % 4 != 0)
            throw new IllegalArgumentException("Length not a multiple of 4");

        int ret_len = (real_len / 4) * 3 - padCount;
        byte[] ret = new byte[ret_len];

        i = 0;
        byte[] t = new byte[4];
        int output_index = 0;
        int j = 0;
        t[0] = t[1] = t[2] = t[3] = 0x3D; // ASCII '='
        while (i < len)
        {
            byte c = data[i++];
            if (c > ' ')
                t[j++] = c;

            if (j == 4)
            {
                output_index += decode(ret, output_index, t[0], t[1], t[2], t[3]);
                j = 0;
                t[0] = t[1] = t[2] = t[3] = 0x3D; // ASCII '='
            }
        }
        if (j > 0)
            decode(ret, output_index, t[0], t[1], t[2], t[3]);

        return ret;
    }

    /**
     * Decodes a UUID-encoded String. Characters with ASCII code points &lt;= 32
     * (this includes whitespace and newlines) are ignored.
     * 
     * @param data
     *        The bytes that have to be decoded.
     * 
     * @return the decoded data.
     * @exception IllegalArgumentException
     *            if data contains invalid characters,
     *            i.e. not codes 0-32, 'A'-'Z', 'a'-'z', '#', '_'. or '=', or is
     *            incorrectly padded.
     * 
     * @reviewed 08/29/99 Stefan Gloy
     */
    public static byte[] decode(String msg) throws IllegalArgumentException
    {
        return decode(msg.getBytes());
    }

    /**
     * Given a block of 4 encoded bytes <code>{ a, b, c, d }</code>, this method
     * decodes up to 3 bytes of output, and stores them starting at <code>ret[ret_offset]</code>.
     * 
     * @param ret
     *        output buffer
     * @param ret_off
     *        buffer offset
     * @param a
     *        encoded byte #1
     * @param b
     *        encoded byte #2
     * @param c
     *        encoded byte #3
     * @param d
     *        encoded byte #4
     * 
     * @return the number of bytes converted.
     * @exception IllegalArgumentException
     *            if a, b, c or d contain invalid
     *            characters, or are incorrectly padded.
     * 
     * @reviewed 08/29/99 Stefan Gloy
     */
    private static int decode(byte[] ret, int ret_off, byte a, byte b, byte c, byte d)
    {
        byte da = dec_table[a];
        byte db = dec_table[b];
        byte dc = dec_table[c];
        byte dd = dec_table[d];

        if (da == -1 || db == -1 || (dc == -1 && c != 0x3D) || (dd == -1 && d != 0x3D))
            throw new IllegalArgumentException("Invalid character [" +
                    (a & 0xFF) + ", " + (b & 0xFF) + ", " + (c & 0xFF) + ", " + (d & 0xFF) + "]");

        ret[ret_off++] = (byte) (da << 2 | db >>> 4);
        if (c == 0x3D) // ASCII '='
            return 1;
        ret[ret_off++] = (byte) (db << 4 | dc >>> 2);
        if (d == 0x3D) // ASCII '='
            return 2;
        ret[ret_off++] = (byte) (dc << 6 | dd);
        return 3;
    }

}
