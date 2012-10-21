package specs

import coffee.CoffeeTracker
import coffee.CoffeeDrinker
import org.eclipse.xtext.xbase.lib.Pair

describe CoffeeTracker {
	
	context "overall consumption is"{
		fact "zero if nobody drinks coffee"{
			coffeeList().overallConsumption => 0
		}
		fact "one if a single person drinks one coffee"{
			coffeeList("Sebastian" -> 1).overallConsumption => 1
		}
		fact "sum of all persons coffees"{
			coffeeList(
				"Sebastian" -> 1, 
				"Birgit" -> 4
			).overallConsumption => 5
		}
	}
	
	context "consumption per person"{
		fact "zero if person does not exist"{
			coffeeList().consumptionOf("unknown") => 0
		}
		fact "one if the person had one coffee"{
			coffeeList("Sebastian" -> 1).consumptionOf("Sebastian") => 1
		}
	}

	def coffeeList(Pair<String, Integer>... coffeeDrinkers){
		new CoffeeTracker(coffeeDrinkers.map[new CoffeeDrinker(key, value)])
	}
}