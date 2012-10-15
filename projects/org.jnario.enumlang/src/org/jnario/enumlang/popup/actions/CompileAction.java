package org.jnario.enumlang.popup.actions;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.jnario.enumlang.utils.FileSystemAccess;
import org.jnario.enumlang.utils.Strings;
import org.jnario.enumlang.utils.WorkspaceAccess;

public class CompileAction implements IObjectActionDelegate {
	
	private List<IFile> selectedFiles;
	private EnumCompiler compiler;
	private EnumParser parser;
	private FileSystemAccess fileSystemAccess;
	
	public CompileAction() {
		this(new EnumCompiler(), new EnumParser(), new WorkspaceAccess());
	}

	public CompileAction(EnumCompiler compiler, EnumParser parser, FileSystemAccess fileSystemAccess) {
		this.parser = parser;
		this.compiler = compiler;
		this.fileSystemAccess = fileSystemAccess;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	public void run(IAction action) {
		for (IFile inputFile : selectedFiles) {
			try {
				String input = Strings.convertToString(inputFile.getContents());
				MyEnum myEnum = parser.parse(input);
				CharSequence content = compiler.compile(myEnum);
				String path = inputFile.getParent().getFullPath().toString() + "/" + myEnum.getName() + ".java";
				fileSystemAccess.createFile(path, content.toString());
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
