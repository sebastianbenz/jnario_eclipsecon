package enumlang

import org.eclipse.jface.viewers.StructuredSelection
import org.jnario.enumlang.popup.actions.CompileAction

import static org.jnario.lib.JnarioCollectionLiterals.*

import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*

Feature: Compiling Enumerations

	Scenario: Compiling a single file
		extension WorkspaceHelper = new WorkspaceHelper
		val selection = list()
				
		Given a selected file "example/Colors.enum" with
		'''
			Colors : BLUE, RED, GREEN
		'''
			val file = createFile(args.first, args.second)
			selection += file
			
		When I compile the selected file(s)
			val action = new CompileAction
			action.selectionChanged(null, new StructuredSelection(selection))
			action.run(null)

		Then I get a file "example/Colors.java" with
		'''
			package enums;
			public class Colors{
				BLUE, RED, GREEN;
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
		When I compile the selected file(s)
		Then I get a file "example/Colors.java" with
		'''
			package enums;
			public class Colors{
				BLUE, RED, GREEN;
			}
		'''
		And I get a file "example/Animals.java" with
		'''
			package enums;
			public class Colors{
				DOG, CAT, HORSE;
			}
		'''