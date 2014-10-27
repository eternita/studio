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
package org.neuro4j.studio.core.buildpath;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.equinox.frameworkadmin.BundleInfo;
import org.eclipse.equinox.simpleconfigurator.manipulator.SimpleConfiguratorManipulator;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.osgi.service.resolver.VersionRange;
import org.neuro4j.studio.core.Neuro4jCorePlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Version;
import org.eclipse.equinox.internal.simpleconfigurator.SimpleConfiguratorImpl;
import org.eclipse.equinox.internal.simpleconfigurator.utils.EquinoxUtils;

class P2Utils
{
    public static BundleInfo findBundle(String symbolicName, Version version, boolean isSourceBundle)
    {
        Assert.isLegal(symbolicName != null);
        Assert.isLegal(version != null);

        return findBundle(symbolicName, new VersionRange(version, true, version, true), isSourceBundle);
    }

    public static BundleInfo findBundle(String symbolicName, VersionRange versionRange, boolean isSourceBundle)
    {
        Neuro4jCorePlugin.logMessage("symbolicName::" + symbolicName + "  " + versionRange.toString() + " " + isSourceBundle);
        Assert.isLegal(symbolicName != null);
        Assert.isLegal(versionRange != null);

        SimpleConfiguratorManipulator manipulator = (SimpleConfiguratorManipulator) Neuro4jCorePlugin.getDefault().getService(SimpleConfiguratorManipulator.class.getName());
        if (manipulator == null) {
            return null;
        }
        BundleInfo bestMatch = null;
        Version bestVersion = null;

        String bundleInfoPath = null;
        if (isSourceBundle) {
            bundleInfoPath = SimpleConfiguratorManipulator.SOURCE_INFO;
        }
        BundleContext context = Neuro4jCorePlugin.getDefault().getBundle().getBundleContext();
        BundleInfo[] bundles = null;
        Neuro4jCorePlugin.logMessage("context::" + context.toString());
        try {
            bundles = loadConfiguration(context, bundleInfoPath, manipulator);
            Neuro4jCorePlugin.logMessage("founded all :" + bundles.length);
        } catch (IOException e) {
            Neuro4jCorePlugin.log(e);
        }

        if (bundles != null) {
            for (int j = 0; j < bundles.length; j++) {
                BundleInfo bundleInfo = bundles[j];
                if (symbolicName.equals(bundleInfo.getSymbolicName())) {
                    Neuro4jCorePlugin.logMessage("founded:" + bundleInfo.toString());
                    Version version = new Version(bundleInfo.getVersion());
                    Neuro4jCorePlugin.logMessage("version:" + version.toString());
                    if (versionRange.isIncluded(version)) {
                        Neuro4jCorePlugin.logMessage("version included:");
                        IPath path = getBundleLocationPath(bundleInfo);
                        if ((path.toFile().exists()) && (
                                (bestMatch == null) || (bestVersion.compareTo(version) < 0))) {
                            bestMatch = bundleInfo;
                            bestVersion = version;
                        }
                    }
                }
            }

        }

        return bestMatch;
    }

    static public BundleInfo[] loadConfiguration(BundleContext context, String infoPath, SimpleConfiguratorManipulator manipulator) throws IOException {
        URI installArea = EquinoxUtils.getInstallLocationURI(context);

        URL configURL = null;
        InputStream stream = null;

        if (infoPath == null) {
          SimpleConfiguratorImpl simpleImpl = new SimpleConfiguratorImpl(context, null);
          configURL = simpleImpl.getConfigurationURL();
        }
        else {
          boolean defaultSource = infoPath == new String("source.info");
          if (defaultSource) {
            infoPath = "org.eclipse.equinox.source/source.info";
          }
          Location configLocation = EquinoxUtils.getConfigLocation(context);
          configURL = configLocation.getDataArea(infoPath);
          try {
            stream = configURL.openStream();
          } catch (FileNotFoundException localFileNotFoundException1) {
            if ((defaultSource) && (configLocation.getParentLocation() != null))
              configURL = configLocation.getParentLocation().getDataArea(infoPath);
            else {
              return new org.eclipse.equinox.frameworkadmin.BundleInfo[0];
            }
          }
        }
        if (configURL == null)
          return new org.eclipse.equinox.frameworkadmin.BundleInfo[0];
        if (stream == null) {
          try {
            stream = configURL.openStream();
          } catch (FileNotFoundException localFileNotFoundException2) {
            return new org.eclipse.equinox.frameworkadmin.BundleInfo[0];
          }

        }

        return manipulator.loadConfiguration(stream, installArea);
}
    
    public static IPath getBundleLocationPath(BundleInfo bundleInfo)
    {
        if (bundleInfo == null) {
            return null;
        }
        Neuro4jCorePlugin.logMessage("Bundle Info:" + bundleInfo.toString());
        URI bundleLocation = bundleInfo.getLocation();
        Neuro4jCorePlugin.logMessage(bundleLocation.toString());
        if (bundleLocation == null)
            return null;
        try
        {
            String fileStr = FileLocator.toFileURL(URIUtil.toURL(bundleLocation)).getPath();
            fileStr = URLDecoder.decode(fileStr, "UTF-8");
            return new Path(fileStr);
        } catch (IOException e) {
            Neuro4jCorePlugin.log(e);
        }
        return null;
    }
}