package enumlang.specs

import enumlang.WorkspaceHelper
import java.io.ByteArrayInputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.Status
import org.eclipse.jface.viewers.StructuredSelection
import org.jnario.enumlang.popup.actions.CompileAction
import org.jnario.enumlang.popup.actions.EnumCompiler
import org.jnario.enumlang.popup.actions.EnumParser
import static org.junit.Assert.*
import static org.mockito.Matchers.*
import static org.mockito.Mockito.*

import static extension org.jnario.lib.Should.*
import org.jnario.enumlang.popup.actions.MyEnum
import static org.jnario.enumlang.popup.actions.MyEnum.*
import org.jnario.enumlang.utils.FileSystemAccess

describe CompileAction {

	extension WorkspaceHelper = new WorkspaceHelper
	
	var enumParser = mock(EnumParser)
	var enumCompiler = mock(EnumCompiler) 
	var fileSystemAccess = mock(FileSystemAccess)
	
	val compileAction = new CompileAction(enumCompiler, enumParser, fileSystemAccess)

	val fileContent = "file content"
	var IFile inputFile 
	
	before inputFile = createFile("examples/src/MyEnum.enum", fileContent)
	
	fact "passes selected file's contents to parser"{
		inputFile.executeCompileAction
		verify(enumParser).parse(fileContent)
	}
	
	fact "wraps core exceptions in runtime exception"{
		inputFile = stub(IFile) =>[
			try{
				when(contents).thenThrow(new CoreException(Status::OK_STATUS))
			}catch(CoreException e){
			}
		]

		inputFile.executeCompileAction throws RuntimeException
	}
		
	fact "passes parsed enum to compiler"{
		val parsedEnum = stub(MyEnum)
		when(enumParser.parse(anyString)).thenReturn(parsedEnum)
		inputFile.executeCompileAction
		
		verify(enumCompiler).compile(parsedEnum)
	}
	
	fact "writes generated java file to input folder"{
		val myEnum = stub(MyEnum)
		
		when(enumParser.parse(anyString)).thenReturn(myEnum)
		when(enumCompiler.compile(myEnum)).thenReturn(fileContent)
		inputFile.executeCompileAction
		verify(fileSystemAccess).createFile("src/enums/Colors.java",fileContent)		
	}
	
	def executeCompileAction(IFile inputFile){
		compileAction.selectionChanged(_, new StructuredSelection(inputFile))
		compileAction.run(_)
	}
	
	def toInputStream(String s){
		new ByteArrayInputStream(s.getBytes())
	}
}

describe EnumParser{ 
	def examples {
		| input    				| name 		| literals  			|
		| "Color"				| "Color"	| list()				|
		| "Color:RED"			| "Color"	| list("RED")			|
		| "Color:RED,GREEN" 	| "Color"	| list("RED", "GREEN")	|
		| "Color : RED , GREEN" | "Color"	| list("RED", "GREEN")	|
	}

	fact "parses enums with the following format 'Name:Literal1,Literal2'"{ 
		examples.forEach[
			val enum = subject.parse(input)
			enum.name => name
			enum.literals => literals
		]
	}
}

describe EnumCompiler{
	fact "generates Java enum for empty enum"{
		compile("Colors") => '''
			package enums;
			
			public enum Colors{
			}
		'''
	}
	
	fact "generates Java enum for multi literal enum"{
		compile("Colors", "RED", "BLUE") => '''
			package enums;
			
			public enum Colors{
				RED, BLUE
			}
		'''
	}
	
	def compile(String name, String... inputs){
		val input = new MyEnum("Colors", inputs)
		subject.compile(input)
	}
}
