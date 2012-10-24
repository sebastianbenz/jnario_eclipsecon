package coffee

import java.util.List

@Data
class CoffeeTracker {
	List<CoffeeDrinker> coffeeDrinkers
	
	def int overallConsumption(){
		if(coffeeDrinkers.empty){
			return 0
		}
		coffeeDrinkers.map[coffeeCount].reduce[a,b| a + b]
	}
	
	def int consumptionOf(String name){
		if(coffeeDrinkers.empty){
			return 0
		}
		coffeeDrinkers.findFirst[it.name == name].coffeeCount
	}
}