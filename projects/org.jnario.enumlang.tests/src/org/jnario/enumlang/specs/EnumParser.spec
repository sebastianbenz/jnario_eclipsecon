package org.jnario.enumlang.specs

import org.jnario.enumlang.popup.actions.EnumParser

/*
 * This is our simple parser
 */
describe EnumParser{ 
	
	
	def examples {
		| input    				| name 		| literals  			|
		| "Color"				| "Color"	| list()				|
		| "Color:RED"			| "Color"	| list("RED")			|
		| "Color:RED,GREEN" 	| "Color"	| list("RED", "GREEN")	|
		| "Color : RED , GREEN" | "Color"	| list("RED", "GREEN")	|
	}

	/*
	 * the format is really **simple**. [this is a random link](http://www.google.com).
	 */
	fact "parses enums with the following format 'Name:Literal1,Literal2'"{ 
		examples.forEach[
			val enum = subject.parse(input)
			enum.name => name
			enum.literals => literals
		]
	}
}