package org.jnario.enumlang.popup.actions;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.jnario.enumlang.utils.Strings;

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
		for (IFile inputFile : selectedFiles) {
			try {
				CharSequence content = compiler.compile(Strings.toString(inputFile.getContents()));
				
				IPath outputFileName = inputFile.getFullPath().removeFileExtension().addFileExtension("java");
				IFile outputFile = inputFile.getWorkspace().getRoot().getFile(outputFileName);
				outputFile.create(Strings.toInputStream(content), true, new NullProgressMonitor());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			selectedFiles = newArrayList(filter(structuredSelection.toList(), IFile.class));
		}
	}

}
