package enumlang

import org.jnario.enumlang.popup.actions.CompileAction
import static org.mockito.Mockito.*
import org.jnario.enumlang.popup.actions.EnumCompiler
import org.eclipse.core.resources.IFile
import org.eclipse.jface.viewers.StructuredSelection

describe CompileAction {
	
	val compiler = mock(EnumCompiler)
	before subject = new CompileAction(compiler)
		
	fact "passes selected files to compiler"{
		val selectedFiles = list(mock(IFile), mock(IFile))
		val selection = new StructuredSelection(selectedFiles)
		
		subject.selectionChanged(_, selection)
		subject.run(_)
		
		verify(compiler) => [
			compile(selectedFiles)
		]
	}
}   