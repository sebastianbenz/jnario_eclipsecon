package enumlang

import java.io.ByteArrayInputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.Status
import org.eclipse.jface.viewers.StructuredSelection
import org.jnario.enumlang.popup.actions.CompileAction
import org.jnario.enumlang.popup.actions.EnumCompiler

import static org.mockito.Matchers.*
import static org.mockito.Mockito.*

import static extension org.jnario.lib.Should.*

describe CompileAction {
	
	extension WorkspaceHelper = new WorkspaceHelper
	
	var enumCompiler = mock(EnumCompiler) 
	
	val compileAction = new CompileAction(enumCompiler)
	
	fact "passes selected file to compiler"{
		var inputFile = createFile("example/Colors.enum", "contents")
		
		inputFile.executeCompileAction
		
		verify(enumCompiler).compile("contents")
	}
	
	fact "rethrows core exceptions in runtime exception"{
		val invalidFile = stub(IFile) => [
			try{
				when(contents).thenThrow(new CoreException(Status::OK_STATUS))
			}catch(CoreException e){}
		]
		
		invalidFile.executeCompileAction throws RuntimeException
	}
	
	fact "writes compilation result to java file with same name as input"{
		var inputFile = createFile("example/Colors.enum", "contents")

		when(enumCompiler.compile(anyString)).thenReturn("result string")
		
		inputFile.executeCompileAction
		
		"example/Colors.java".fileContents => "result string"
	}
	
	def executeCompileAction(IFile inputFile){
		compileAction.selectionChanged(_, new StructuredSelection(inputFile))
		compileAction.run(_)
	}
	
	def toInputStream(String s){
		new ByteArrayInputStream(s.getBytes())
	}
}   