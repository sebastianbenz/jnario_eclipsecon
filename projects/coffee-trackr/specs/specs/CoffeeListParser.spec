package specs

import coffee.CoffeeDrinker
import coffee.CoffeeListParser

import static org.jnario.lib.JnarioCollectionLiterals.*

import static extension org.jnario.lib.ExampleTableIterators.*
import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*

describe CoffeeListParser {
	val parser = new CoffeeListParser
	
	def coffeeDrinkers{
		| coffeList			| expectedName | expectedCoffeeCount 	|
		| "Sebastian"		| "Sebastian"  | 0				|
		| "Sebastian "		| "Sebastian"  | 0				|
		| "Sebastian |"		| "Sebastian"  | 1				|
		| "Sebastian ||"	| "Sebastian"  | 2				|
		| "Sebastian |||"	| "Sebastian"  | 3				|
	}
	
	fact "coffee consumption per person has the format Name |||"{
		coffeeDrinkers.forEach[
			val coffeeDrinker = parse(coffeList).first
			coffeeDrinker.name 			=> expectedName
			coffeeDrinker.coffeeCount 	=> expectedCoffeeCount 
		]
	}

	fact "coffee drinkers are separated by newline"{
		'''
			Sebastian ||
			Birgit |
		'''.parse => list(
			new CoffeeDrinker("Sebastian", 2),
			new CoffeeDrinker("Birgit", 1)
		)
		
	}

	def parse(CharSequence string) {
		subject.parse(string.toString)
	}
}