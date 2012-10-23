package coffee

import java.util.List

class CoffeeListParser {
	
	def List<CoffeeDrinker> parse(String input){
		if(input.empty) return emptyList
		
		val lines = input.split("\n")
		lines.map[parseCoffeeDrinker]
	}
	
	def parseCoffeeDrinker(String input){
		val firstPipeIndex = input.indexOf("|")
		var name = input
		var count = 0
		if(firstPipeIndex > -1){
			name = input.substring(0, firstPipeIndex)
			count = input.length - firstPipeIndex
		}
		new CoffeeDrinker(name.trim, count)
	}
	
}