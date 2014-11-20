package org.neuro4j.studio.core.views;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.internal.ui.infoviews.JavadocView;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.impl.LogicNodeImpl;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.ListEntryType;
import org.neuro4j.studio.core.util.search.ResourceSearchEngine;

@SuppressWarnings("restriction")
public class FlowdocView extends JavadocView {

    ResourceSearchEngine searchEngine = new ResourceSearchEngine();

    @Override
    protected Object computeInput(IWorkbenchPart part, ISelection selection, IJavaElement input, IProgressMonitor monitor) {
        // TODO Auto-generated method stub
        if (selection instanceof StructuredSelection)
        {
            StructuredSelection ss = (StructuredSelection) selection;
            if (ss.getFirstElement() instanceof LogicNodeEditPart) {
                LogicNodeEditPart node = (LogicNodeEditPart) ss.getFirstElement();
                LogicNodeImpl actionNode = (LogicNodeImpl) node.getActionNode();
                String className = actionNode.getClassName();
                if (className == null)
                {
                    return null;
                }
                input = getInput(input, actionNode.getClassName());
            } else if (ss.getFirstElement() instanceof ListEntry)
            {
                ListEntry entry = (ListEntry) ss.getFirstElement();
                if (entry.getType() != ListEntryType.CUSTOM_BLOCK && entry.getType() != ListEntryType.TRIGGER_BLOCK)
                {
                    return null;
                }
                String className = entry.getMessage();
                if (className == null)
                {
                    return null;
                }
                input = getInput(input, className);
            }

        }
        return super.computeInput(part, selection, input, monitor);
    }

    private IJavaElement getInput(IJavaElement input, String actionNode) {
        try {
            List<IFile> files = searchEngine.findFiles(actionNode.replace(".", "/").concat(".java"));
            if (files != null && files.size() == 1)
            {
                input = getJavaElements(files.get(0));
            } else {

            }

        } catch (CoreException e) {
            e.printStackTrace();
        }
        return input;
    }

    private IJavaElement getJavaElements(Object object) {

        if (object instanceof IAdaptable) {
            IJavaElement element = (IJavaElement) ((IAdaptable) object).getAdapter(IJavaElement.class);
            if (element != null) {
                if (element instanceof IMember && ((IMember) element).getDeclaringType() != null) {
                    element = ((IMember) element).getDeclaringType();
                }
                return element;
            }

        }
        return null;
    }

}
