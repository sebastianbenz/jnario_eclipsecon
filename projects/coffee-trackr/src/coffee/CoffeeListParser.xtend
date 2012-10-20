package coffee

import java.util.List

class CoffeeListParser {
	
	def List<CoffeeDrinker> parse(String input){
		input.split("\n").map[createCoffeeDrinker]
	}
	
	def createCoffeeDrinker(String input){
		val index = input.indexOf("|")
		
		var name = ""
		var count = 0
		if(index == -1){
			name = input
		}else{
			name = input.substring(0, index)
			count = input.substring(index-1).replaceAll("^\\|", "").length-1
		}
		
		new CoffeeDrinker(name.trim, count)
	}
	
}