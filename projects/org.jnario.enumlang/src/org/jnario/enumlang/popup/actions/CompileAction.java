package org.jnario.enumlang.popup.actions;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class CompileAction implements IObjectActionDelegate {

	private List<IFile> selectedFiles;
	private EnumCompiler compiler;
	
	public CompileAction() {
		this(new EnumCompiler());
	}
	
	public CompileAction(EnumCompiler compiler) {
		this.compiler = compiler;
	}
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	public void run(IAction action) {
		compiler.compile(selectedFiles);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			selectedFiles = newArrayList(filter(structuredSelection.toList(), IFile.class));
		}
	}

}
