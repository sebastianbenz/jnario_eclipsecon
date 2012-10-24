package coffee

import java.util.List

class CoffeeListParser {
	
	def List<CoffeeDrinker> parse(String input){
		if(input.empty){
			return emptyList
		}
		input.split("\n").map[createCoffeeDrinker]
	}
	def CoffeeDrinker createCoffeeDrinker(String string) {
		val i = string.indexOf("|")
		var name = string
		var coffeeCount = 0
		if(i > -1){
			name = name.substring(0, i)
			coffeeCount = string.length - name.length
		}
		return new CoffeeDrinker(name.trim, coffeeCount)
	}

	
	
}