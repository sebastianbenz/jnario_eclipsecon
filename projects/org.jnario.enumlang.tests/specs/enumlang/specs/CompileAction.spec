package enumlang.specs

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
import enumlang.WorkspaceHelper
import org.eclipse.core.runtime.Path

describe CompileAction {
	
	extension WorkspaceHelper = new WorkspaceHelper
	var enumCompiler = mock(EnumCompiler) 
	val compileAction = new CompileAction(enumCompiler)
	var inputFile = stub(IFile) => [
		when(fullPath).thenReturn(new Path("example/MyEnum.enum"))
	]
	
	fact "passes selected file's contents to compiler"{
		inputFile.executeCompileAction
		verify(enumCompiler).compile("contents")
	}
	
	fact "wraps core exceptions in runtime exception"{
		when(inputFile.contents).thenThrow(new CoreException(Status::OK_STATUS))
		
		inputFile.executeCompileAction throws RuntimeException
	}
	
	fact "writes compilation result to java file with same name as input"{
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