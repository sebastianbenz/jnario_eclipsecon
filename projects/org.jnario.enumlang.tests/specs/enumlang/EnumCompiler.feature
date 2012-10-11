package enumlang

import org.eclipse.jface.viewers.StructuredSelection
import org.jnario.enumlang.popup.actions.CompileAction

import static org.jnario.lib.JnarioCollectionLiterals.*

import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*
import static org.junit.Assert.*

Feature: Compiling Enumerations

	In order to develop faster 
	as a Java programmer
	I want a concise syntax for enumerations

	Scenario: Compiling a single file
		extension WorkspaceHelper = new WorkspaceHelper
		val selection = list()
				
		Given a selected file "example/Colors.enum" with
		'''
			Colors : BLUE, RED, GREEN
		'''
			selection += createFile(args.first, args.second)
		When I execute the compile action
			val action = new CompileAction
			action.selectionChanged(_, new StructuredSelection(selection))
			action.run(_)
		Then I get a file "example/Colors.java" with
		'''
			package enums;
			
			public enum Colors {
				BLUE, RED, GREEN
			}
		'''
			getFileContents(args.first) => args.second

	Scenario: Compiling multiple files
		
		Given a selected file "example/Colors.enum" with
		'''
			Colors : BLUE, RED, GREEN
		'''
		And a selected file "example/Animals.enum" with
		'''
			Animals : DOG, CAT, HORSE
		'''
		When I execute the compile action
		Then I get a file "example/Colors.java" with
		'''
			package enums;
			
			public enum Colors {
				BLUE, RED, GREEN
			}
		'''
		And I get a file "example/Animals.java" with
		'''
			package enums;
			
			public enum Animals {
				DOG, CAT, HORSE
			}
		'''