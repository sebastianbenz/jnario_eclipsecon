package enumlang

import org.jnario.enumlang.popup.actions.CompileAction
import org.eclipse.jface.viewers.StructuredSelection

Feature: Compiling Enumerations

	Scenario: Compiling a single file
		extension WorkspaceHelper helper = new WorkspaceHelper
		val selection = list()
				
		Given a selected file "example/MyEnum.enum" with
		'''
			Colors : BLUE, RED, GREEN
		'''
			val file = createFile(args.first, args.second)
			selection += file
			
		When I compile "example/MyEnum.enum"
			val action = new CompileAction
			action.selectionChanged(null, new StructuredSelection(selection))
			action.run(null)
			
		Then I get a file "example/MyEnum.java" with
		'''
			package enums;
			public class Colors{
				BLUE, RED, GREEN;
			}
		'''
			getFileContents(args.first) => args.second