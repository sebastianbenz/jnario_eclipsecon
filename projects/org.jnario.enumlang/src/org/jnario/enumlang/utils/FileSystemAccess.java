package org.jnario.enumlang.utils;

import org.eclipse.core.resources.IFile;

public interface FileSystemAccess {

	void createFile(IFile context, MyEnum myEnum, CharSequence content);

}
