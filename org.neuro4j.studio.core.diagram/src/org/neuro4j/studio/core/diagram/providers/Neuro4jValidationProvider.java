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
package org.neuro4j.studio.core.diagram.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.ScrollPaneSolver.Result;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.diagram.edit.parts.NetworkEditPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.ext.utils.ConnectionValidatorHelper;

/**
 * @generated
 */
public class Neuro4jValidationProvider {

    /**
     * @generated
     */
    private static boolean constraintsActive = false;

    /**
     * @generated
     */
    public static boolean shouldConstraintsBePrivate() {
        return false;
    }

    /**
     * @generated
     */
    public static void runWithConstraints(
            TransactionalEditingDomain editingDomain, Runnable operation) {
        final Runnable op = operation;
        Runnable task = new Runnable() {
            public void run() {
                try {
                    constraintsActive = true;
                    op.run();
                } finally {
                    constraintsActive = false;
                }
            }
        };
        if (editingDomain != null) {
            try {
                editingDomain.runExclusive(task);
            } catch (Exception e) {
                Neuro4jDiagramEditorPlugin.getInstance().logError("Validation failed", e); //$NON-NLS-1$
            }
        } else {
            task.run();
        }
    }

    /**
     * @generated
     */
    static boolean isInDefaultEditorContext(Object object) {
        if (shouldConstraintsBePrivate() && !constraintsActive) {
            return false;
        }
        if (object instanceof View) {
            return constraintsActive
                    && NetworkEditPart.MODEL_ID.equals(Neuro4jVisualIDRegistry
                            .getModelID((View) object));
        }
        return true;
    }

    public static class Adapter1 extends AbstractModelConstraint {

        /**
         * @generated NOT
         */
        public IStatus validate(IValidationContext ctx) {
            Node context = (Node) ctx.getTarget();
            Edge edge = (Edge) ctx.getTarget();
            Result result = (Result) edge.getTarget().getElement();
            boolean cycleDetected = ConnectionValidatorHelper.validate();
            return cycleDetected ? ctx.createFailureStatus(edge) : ctx
                    .createSuccessStatus();
        }
    }

}
