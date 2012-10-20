package specs

import coffee.CoffeeListParser
import coffee.CoffeeDrinker

describe CoffeeListParser {
	
	val parser = new CoffeeListParser
	
	def coffeeDrinkers{
		| input 			| expectedName | expectedCount 	|
		| "Sebastian"		| "Sebastian"  | 0				|
		| "Sebastian "		| "Sebastian"  | 0				|
		| "Sebastian |"		| "Sebastian"  | 1				|
		| "Sebastian ||"	| "Sebastian"  | 2				|
		| "Sebastian |||"	| "Sebastian"  | 3				|
	}
	
	fact "coffee consumption per person has the format Name |||"{
		coffeeDrinkers.forEach[
			val coffeeDrinkers = subject.parse(input)
			val coffeDrinker = coffeeDrinkers.first
			coffeDrinker.name 		=> expectedName
			coffeDrinker.coffeeCount => expectedCount 
		]
	}
	
	fact "coffee drinker are separated by newline"{
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