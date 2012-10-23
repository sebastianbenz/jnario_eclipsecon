package specs

import coffee.CoffeeDrinker
import coffee.CoffeeListParser

import static org.jnario.lib.JnarioCollectionLiterals.*

import static extension org.jnario.lib.ExampleTableIterators.*
import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*

describe CoffeeListParser {
	
	val parser = new CoffeeListParser
	
	fact "empty list has not coffeedrinkers"{
		val coffeeDrinkers = parser.parse("")
		assert coffeeDrinkers.empty
	}
	
	def examples {
		| input 			| name			| count 	|
		| "Sebastian"		| "Sebastian"	| 0			|
		| "Sebastian|"		| "Sebastian"	| 1			|
		| "Sebastian||"		| "Sebastian"	| 2			|
		| "Sebastian ||"	| "Sebastian"	| 2			|
									
	}
	
	fact "coffee drinking count has the format NAME |*"{
		examples.forEach[
			val coffeeDrinkers = parser.parse(input)
			val firstDrinker = coffeeDrinkers.first
			firstDrinker.name 			=> name
			firstDrinker.coffeeCount 	=> count
		]
	}
	
	fact "multiple coffeedrinkers are separated by newline"{
		val coffeeDrinkers = parser.parse('''
			Sebastian 	|||
			Birgit 		||
		'''.toString)
		coffeeDrinkers.size => 2
	}

}