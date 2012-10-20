package coffee

import java.util.List

@Data
class CoffeeTracker {
	List<CoffeeDrinker> coffeeDrinkers
	
	def overallConsumption(){
		coffeeDrinkers.map[coffeeCount].fold(0)[a , b | a + b]
	}
	
	def consumptionOf(String name){
		val coffeeDrinker = coffeeDrinkers.findFirst[it.name == name]
		if(coffeeDrinker == null){
			0
		}else{
			coffeeDrinker.coffeeCount
		}
	}
}