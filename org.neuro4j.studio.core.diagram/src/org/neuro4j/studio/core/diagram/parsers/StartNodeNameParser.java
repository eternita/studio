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
package org.neuro4j.studio.core.diagram.parsers;

import java.text.ParsePosition;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.osgi.util.NLS;
import org.neuro4j.studio.core.diagram.part.Messages;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.impl.StartNodeImpl;

public class StartNodeNameParser extends MessageFormatParser {

    public StartNodeNameParser(EAttribute[] features) {
        super(features);

    }

    public StartNodeNameParser(EAttribute[] features,
            EAttribute[] editableFeatures) {
        super(features, editableFeatures);
    }

    public IParserEditStatus isValidEditString(IAdaptable adapter,
            String editString) {
        StartNodeImpl startNode = (StartNodeImpl) adapter.getAdapter(StartNodeImpl.class);
        ParsePosition pos = new ParsePosition(0);
        Object[] values = getEditProcessor().parse(editString, pos);
        if (values == null) {
            return new ParserEditStatus(Neuro4jDiagramEditorPlugin.ID,
                    IParserEditStatus.UNEDITABLE, NLS.bind(
                            Messages.MessageFormatParser_InvalidInputError,
                            new Integer(pos.getErrorIndex())));
        }

        if (!startNode.isValidName((String) values[0], startNode)) {
            return new ParserEditStatus(Neuro4jDiagramEditorPlugin.ID,
                    IParserEditStatus.UNEDITABLE, NLS.bind(
                            Messages.MessageFormatParser_InvalidInputError,
                            new Integer(pos.getErrorIndex())));
        }
        return validateNewValues(values);
    }

}
