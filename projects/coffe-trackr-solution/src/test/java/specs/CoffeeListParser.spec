package specs

import coffee.CoffeeListParser

import static org.jnario.lib.JnarioCollectionLiterals.*

import static extension org.jnario.lib.ExampleTableIterators.*
import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*

/*
 * This is a simple parser for coffee lists.
 */
describe CoffeeListParser {
	
	fact "Empty string has no coffee drinkers"{
		"".parse => emptyList
	}

	def examples{
		| input					| expectedName 	| expectedCoffeeCount 	|
		| "Sebastian"			| "Sebastian"	| 0						|
		| "Sebastian|"			| "Sebastian"	| 1						|
		| "Sebastian |"			| "Sebastian"	| 1						|
		| "Sebastian |||"		| "Sebastian"	| 3						|
	}

	fact "Coffee per drinker has the format NAME |*"{
		examples.forEach[
			val coffeeDrinker = input.parse.first
			coffeeDrinker.name 			=> expectedName
			coffeeDrinker.coffeeCount 	=> expectedCoffeeCount
		]
	}
	
	fact "Multiple coffee drinkers are separated by newline characters"{
		'''
			Sebastian 	||
			Birgit 		|||
		'''.parse.size => 2
	}
	
	
	def parse(CharSequence s){
		subject.parse(s.toString)
	}
}