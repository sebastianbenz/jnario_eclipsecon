package specs

import coffee.CoffeeDrinker
import coffee.CoffeeListParser

import static org.jnario.lib.JnarioCollectionLiterals.*

import static extension org.jnario.lib.ExampleTableIterators.*
import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*

describe CoffeeListParser {
	
	fact "empty list has no coffee drinkers"{
		"".parse => emptyList
	}

	def examples{
		| input					| expectedName 	| expectedCoffeeCount 	|
		| "Sebastian"			| "Sebastian"	| 0						|
		| "Sebastian|"			| "Sebastian"	| 1						|
		| "Sebastian |"			| "Sebastian"	| 1						|
		| "Sebastian |||"		| "Sebastian"	| 3						|
	}

	fact "coffee per drinker has the format NAME |*"{
		examples.forEach[
			val coffeeDrinker = input.parse.first
			coffeeDrinker.name 			=> expectedName
			coffeeDrinker.coffeeCount 	=> expectedCoffeeCount
		]
	}
	
	fact "multiple coffee drinkers are separated by newlines"{
		'''
			Sebastian 	||
			Birgit 		|||
		'''.parse.size => 2
	}
	
	def parse(CharSequence s){
		subject.parse(s.toString)
	}
}