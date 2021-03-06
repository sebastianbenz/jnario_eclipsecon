package org.jnario.enumlang.popup.actions;

import static com.google.common.collect.Iterables.filter;
import static org.jnario.enumlang.utils.Strings.convertToString;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.jnario.enumlang.utils.FileSystemAccess;
import org.jnario.enumlang.utils.WorkspaceAccess;

public class CompileAction implements IObjectActionDelegate {
	
	private Iterable<IFile> selectedFiles;
	private EnumCompiler compiler;
	private EnumParser parser;
	private FileSystemAccess fileSystemAccess;
	
	public CompileAction() {
		this(new EnumCompiler(), new EnumParser(), new WorkspaceAccess());
	}

	public CompileAction(EnumCompiler compiler, EnumParser parser, FileSystemAccess fileSystemAccess) {
		this.compiler = compiler;
		this.parser = parser;
		this.fileSystemAccess = fileSystemAccess;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	public void run(IAction action) {
		for (IFile inputFile : selectedFiles) {
			try {
				String input = convertToString(inputFile.getContents());
				MyEnum myEnum = parser.parse(input);
				CharSequence content = compiler.compile(myEnum);
				fileSystemAccess.createFile(inputFile, myEnum, content);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			selectedFiles = filter(structuredSelection.toList(), IFile.class);
		}
	}

}
