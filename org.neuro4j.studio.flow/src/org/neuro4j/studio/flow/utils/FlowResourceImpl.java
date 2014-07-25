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
package org.neuro4j.studio.flow.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.NoteNode;
import org.neuro4j.studio.core.format.f4j.FlowConverter;
import org.neuro4j.studio.core.format.f4j.FlowXML;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.format.n4j.ConvertationException;
import org.neuro4j.studio.core.format.n4j.NetworkConverter;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.relation.ActionNodeRelationProcessorFactory;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;
import org.neuro4j.studio.core.util.search.CallNodeResolver;
import org.neuro4j.studio.flow.convert.Entity2ECoreConverter;
import org.neuro4j.studio.flow.convert.impl.Entity2ECoreConverterImpl;
import org.neuro4j.studio.flow.convert.impl.Neuro2XMLSaveImpl;
import org.neuro4j.workflow.common.FlowInitializationException;
import org.neuro4j.workflow.enums.FlowVisibility;
import org.neuro4j.workflow.node.WorkflowNode;
import org.xml.sax.InputSource;

public class FlowResourceImpl extends GMFResource {

    private Entity2ECoreConverter converter;

    private boolean loadingInProgress = false;

    public FlowResourceImpl(URI uri) {
        super(uri);
        loadingInProgress = false;

        setIntrinsicIDToEObjectMap(new HashMap<String, EObject>());
    }

    @Override
    public void load(Map<?, ?> options) throws IOException {
        if (options.get(Network.DEFAULT_NAME) == null) {
            return;
        }
        super.load(options);
    }

    @Override
    public void doLoad(InputStream inputStream, Map<?, ?> options)
            throws IOException {
        loadingInProgress = true;

        if (options == null) {
            return;
        }
        Network eNetwork = (Network) options.get(Network.DEFAULT_NAME);
        eNetwork.setResource(null);

        converter = new Entity2ECoreConverterImpl(eNetwork);
        FlowXML network = xml2network(inputStream);
        Collection<NodeXML> entitiesIds = network.getXmlNodes();
        Map<String, EObject> map = getIntrinsicIDToEObjectMap();
        eNetwork.setVisibility(network.visibility);
        for (NodeXML entity : entitiesIds)
        {
            if (map != null)
            {
                ActionNode eObject = (ActionNode) converter.convert(entity);

                if (eObject != null)
                {
                    String eObjectId = EcoreUtil.getID(eObject);
                    eObject.setNetwork(eNetwork);
                    map.put(eObjectId, eObject);
                    if (eObject instanceof NoteNode)
                    {
                        eNetwork.addNote((NoteNode) eObject);
                    } else {
                        getContents().add(eObject);
                    }

                    if (eObject.getName() == null)
                    {
                        generateNodeName(eObject, eNetwork);
                    }
                    eNetwork.processNodeCount(eObject);

                } 
            }
        }

        // entitiesIds = FlowUtils.getEntities(network);

        for (NodeXML entity : entitiesIds)
        {
            // Connected entity = network.getById(uuid);
            ActionNodeImpl eobjMain = (ActionNodeImpl) map.get(entity.getUuid());
            if (eobjMain == null)
            {
                continue;
            }

            ActionRelationProcessor actionRelationProcessor = ActionNodeRelationProcessorFactory.getInstance().createProcessor(eobjMain);
            actionRelationProcessor.processRelation(eobjMain, entity, map);

        }
        // :)
        if (entitiesIds != null && entitiesIds.size() == 0)
        {
            loadingInProgress = false;
        }

    }



    private void loadNetworkConfiguration(NodeXML entity, Network eNetwork)
    {
        String visibility = entity.getParameter(eNetwork.VISIBILITY_KEY);
        if (visibility == null)
        {
            visibility = FlowVisibility.getDefault().name();
        }
        eNetwork.setVisibility(visibility);

    }

    /**
     * Generates next node's name based on how many nodes are in the flow.
     * 
     * @param node
     * @param eNetwork
     */
    private void generateNodeName(ActionNode node, Network eNetwork)
    {
        int count = eNetwork.getNodeCount(node);
        node.setName(node.getDefaultName() + (count + 1));
    }

    @Override
    public void doLoad(InputSource inputSource, Map<?, ?> options)
            throws IOException {
    }

    @Override
    protected void doUnload() {
        // TODO Auto-generated method stub
        super.doUnload();
    }

    private static FlowXML xml2network(InputStream stream) {
        try {
			return FlowConverter.xml2workflow(stream, "123");		
		} catch (FlowInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new FlowXML();
    }

    @Override
    public void save(Map<?, ?> options) throws IOException {

        CallNodeResolver.getInstance().removeFromCache(getURI());
        super.save(options);
    }

    @Override
    protected void saveOnlyIfChangedWithFileBuffer(Map<?, ?> options)
            throws IOException {
        // TODO Auto-generated method stub
        super.saveOnlyIfChangedWithFileBuffer(options);
    }

    @Override
    protected void saveOnlyIfChangedWithMemoryBuffer(Map<?, ?> options)
            throws IOException {
        // TODO Auto-generated method stub
        super.saveOnlyIfChangedWithMemoryBuffer(options);
    }

    @Override
    public void setModified(boolean isModified) {
        // TODO Auto-generated method stub
        super.setModified(isModified);
    }

    @Override
    protected XMLSave createXMLSave()
    {
        return new Neuro2XMLSaveImpl(createXMLHelper());
    }

    @Override
    public void eNotify(Notification notification) {
        // TODO Auto-generated method stub
        super.eNotify(notification);

    }

    @Override
    protected Adapter createModificationTrackingAdapter()
    {
        return new ModificationTrackingAdapter();
    }

    /**
     * An adapter implementation for tracking resource modification.
     */
    protected class ModificationTrackingAdapter extends AdapterImpl
    {
        @Override
        public void notifyChanged(Notification notification)
        {

            if (!isLoadingInprogress() && shoudBeUpdated(notification))
            {
                setModified(true);
            }

            checkIfDocumentLoaded(notification);

            if (!isModified() && isModifyingChange(notification)) {
                super.notifyChanged(notification);
            }
        }
    }

    private boolean shoudBeUpdated(Notification notification)
    {
        if (notification.getFeature() instanceof org.eclipse.emf.ecore.impl.EAttributeImpl)
        {
            EAttributeImpl feature = (EAttributeImpl) notification.getFeature();
            if (feature.getName().equals("mutable")) {
                return false;
            }
        }

        return true;
    }

    private void checkIfDocumentLoaded(Notification notification)
    {
        if (!loadingInProgress)
            return;
        if (notification.getNotifier() instanceof Diagram) {
            if (notification.getNewStringValue() != null && notification.getNewStringValue().equals("loaded")) {
                loadingInProgress = false;
            }
        }
    }

    private boolean isLoadingInprogress()
    {
        return loadingInProgress;
    }

    @Override
    public TreeIterator<EObject> getAllContents() {
        // TODO Auto-generated method stub
        return super.getAllContents();
    }

    @Override
    public EList<EObject> getContents() {
        // TODO Auto-generated method stub
        return super.getContents();
    }

}