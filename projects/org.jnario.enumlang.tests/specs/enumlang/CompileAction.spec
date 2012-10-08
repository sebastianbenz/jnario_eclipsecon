package enumlang

import org.jnario.enumlang.popup.actions.CompileAction
import static org.mockito.Mockito.*
import org.jnario.enumlang.popup.actions.EnumCompiler
import org.eclipse.core.resources.IFile
import org.eclipse.jface.viewers.StructuredSelection

describe CompileAction {
	
	val compiler = mock(typeof(EnumCompiler))
	
	before subject = new CompileAction(compiler)
		
	fact "passes selected files to compiler"{
		val selectedFiles = list(mock(typeof(IFile)), mock(typeof(IFile)))
		val selection = new StructuredSelection(selectedFiles)
		
		subject.selectionChanged(null, selection)
		subject.run(null)
		
		verify(compiler).compile(selectedFiles)
	}

}