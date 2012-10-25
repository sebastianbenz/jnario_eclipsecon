package specs

import coffee.CoffeeTracker
import coffee.CoffeeDrinker
import org.eclipse.xtext.xbase.lib.Pair

/*
 * This is our coffee calculation engine.
 */
describe CoffeeTracker {

	context "Overall consumption is"{

		fact "Zero with zero coffee drinkers"{
			coffeeDrinkers().overallConsumption => 0
		}
		
		fact "Two with single coffee drinker with two coffees"{
			coffeeDrinkers("Sebastian" -> 2).overallConsumption => 2
		}
	}
	
	context "Consumption per person is"{
		
		fact "Zero with zero coffee drinkers"{
			coffeeDrinkers().consumptionOf("somebody") => 0
		}
		
		fact "Coffee count of person with given name"{
			coffeeDrinkers(
				"Sebastian" -> 3,
				"Birgit" -> 2
			).consumptionOf("Birgit") => 2
		}
	}
	
	def coffeeDrinkers(Pair<String, Integer>... params){
		val coffeeDrinkers = params.map[new CoffeeDrinker(key, value)]
		new CoffeeTracker(coffeeDrinkers)
	}
		
}