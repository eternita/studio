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
package org.neuro4j.studio.properties.sources.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;
import org.neuro4j.studio.core.impl.StandardNodeImpl;
import org.neuro4j.studio.properties.sources.DecisionNodePropertySource;
import org.neuro4j.studio.properties.sources.LogicNodePropertySource;
import org.neuro4j.studio.properties.sources.MapperNodePropertySource;
import org.neuro4j.studio.properties.sources.NetworkPropertySource;
import org.neuro4j.studio.properties.sources.Neuro4jPropertySource;
import org.neuro4j.studio.properties.sources.OutputPropertySource;
import org.neuro4j.studio.properties.sources.StandardListPropertySource;
import org.neuro4j.studio.properties.sources.StartNodePropertySource;
import org.neuro4j.studio.properties.sources.ViewNodePropertySource;

public class Nuero4jPropertySourceProvider implements IPropertySourceProvider {
    private AdapterFactory adapterFactory;

    // Map<Object, IPropertySource> map = new HashMap<Object, IPropertySource>();
    public Nuero4jPropertySourceProvider(AdapterFactory adapterFactory) {
        super();
        this.adapterFactory = adapterFactory;
    }

    @Override
    public IPropertySource getPropertySource(Object object) {
        if (object instanceof IPropertySource) {
            return (IPropertySource) object;
        } else {
            IItemPropertySource itemPropertySource = (IItemPropertySource) (object instanceof EObject
                    && ((EObject) object).eClass() == null ? null
                    : adapterFactory.adapt(object, IItemPropertySource.class));

            return itemPropertySource != null ? createPropertySource(object,
                    itemPropertySource) : null;
        }
    }

    private IPropertySource createPropertySource(Object object,
            IItemPropertySource itemPropertySource) {

        if (object instanceof ActionNode)
        {
            ActionNode actionNode = (ActionNode) object;

            if (actionNode.getPropertySource() != null)
            {
                return actionNode.getPropertySource();
            } else {
                if (object instanceof MapperNode)
                {
                    MapperNodePropertySource mnpSource = new MapperNodePropertySource(object, itemPropertySource, this.adapterFactory);
                    actionNode.setPropertySource(mnpSource);
                    return actionNode.getPropertySource();

                } else if (object instanceof LogicNode)
                {
                    LogicNodePropertySource mnpSource = new LogicNodePropertySource(object, itemPropertySource, this.adapterFactory);
                    actionNode.setPropertySource(mnpSource);
                    return actionNode.getPropertySource();

                } else if (object instanceof DecisionNode) {
                    DecisionNodePropertySource mnpSource = new DecisionNodePropertySource(
                            object, itemPropertySource, this.adapterFactory);
                    actionNode.setPropertySource(mnpSource);
                    return actionNode.getPropertySource();

                } else if (object instanceof StartNode) {
                    StartNodePropertySource mnpSource = new StartNodePropertySource(
                            object, itemPropertySource, this.adapterFactory);
                    actionNode.setPropertySource(mnpSource);
                    return actionNode.getPropertySource();

                } else if (object instanceof ViewNode) {
                    ViewNodePropertySource mnpSource = new ViewNodePropertySource(
                            object, itemPropertySource, this.adapterFactory);
                    actionNode.setPropertySource(mnpSource);
                    return actionNode.getPropertySource();

                } else if (object instanceof StandardNodeImpl) {
                    StandardListPropertySource sSource = new StandardListPropertySource((StandardNodeImpl) object);
                    actionNode.setPropertySource(sSource);
                    return actionNode.getPropertySource();
                }
                else {
                    Neuro4jPropertySource mnpSource = new Neuro4jPropertySource(
                            object, itemPropertySource, this.adapterFactory);
                    actionNode.setPropertySource(mnpSource);
                    return actionNode.getPropertySource();
                }
            }
        } else if (object instanceof OperatorOutput)
        {
            return getOutputPropertySource(object, itemPropertySource);
        } else if (object instanceof Network)
        {
            // Network output = (Network)object;
            // if (map.containsKey(output.getId())){
            // return map.get(output.getId());
            // } else {
            NetworkPropertySource networkSource = new NetworkPropertySource(object, itemPropertySource, this.adapterFactory);
            // map.put(output.getId(), mnpSource);
            return networkSource;
            // }
        }

        return new Neuro4jPropertySource(object, itemPropertySource, this.adapterFactory);

        // Returns the custom property source
        // return null;
    }

    private IPropertySource getOutputPropertySource(Object object,
            IItemPropertySource itemPropertySource) {
        OperatorOutput output = (OperatorOutput) object;
        if (output.getPropertySource() != null) {
            return output.getPropertySource();
        } else {
            Node candidate = getStandardRelation(output);
            if (candidate != null) {

                StandardListPropertySource sSource = new StandardListPropertySource(candidate);
                candidate.setPropertySource(sSource);
                return candidate.getPropertySource();
            } else {
                OutputPropertySource mnpSource = new OutputPropertySource(object, itemPropertySource, this.adapterFactory);

                output.setPropertySource(mnpSource);
                return output.getPropertySource();
            }

        }
    }

    private Node getStandardRelation(OperatorOutput output)
    {
        if (output.eContainer() instanceof StandardNodeImpl || output.getTarget() instanceof StandardNodeImpl) {
            if (output.eContainer() != null && output.eContainer() instanceof StandardNodeImpl)
            {
                StandardNodeImpl v1 = (StandardNodeImpl) output.eContainer();
                if (v1.isCircleRelation())
                {
                    return v1;
                }
            }

            if (output.getTarget() != null)
            {
                StandardNodeImpl v1 = (StandardNodeImpl) output.getTarget();
                if (v1.isCircleRelation())
                {
                    return v1;
                }
            }

            return output;

        }

        return null;
    }

}
