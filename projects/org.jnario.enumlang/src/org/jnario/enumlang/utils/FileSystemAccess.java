package org.jnario.enumlang.utils;

import org.eclipse.core.resources.IFile;
import org.jnario.enumlang.popup.actions.MyEnum;

public interface FileSystemAccess {

	void createFile(IFile context, MyEnum myEnum, CharSequence content);

}
