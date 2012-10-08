package enumlang

Feature: Compiling Enumerations

	Scenario: Compiling a single file
		
		Given a file "example/MyEnum.enum" with
		'''
			Colors : BLUE, RED, GREEN
		'''
		When I compile "example/MyEnum.enum"
		Then I get a file "example/MyEnum.java" with
		'''
			package enums;
			public class Colors{
				BLUE, RED, GREEN;
			}
		'''