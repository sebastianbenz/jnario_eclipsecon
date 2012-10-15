package org.jnario.enumlang.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

public class WorkspaceAccess implements FileSystemAccess {

	private IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
	
	@Override
	public void createFile(String path, String contents) {
		IFile file = workspaceRoot.getFile(new Path(path));
		try {
			file.create(new StringInputStream(contents), true, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

}
