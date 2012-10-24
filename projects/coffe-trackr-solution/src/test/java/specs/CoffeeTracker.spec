package specs

import coffee.CoffeeTracker
import coffee.CoffeeDrinker

describe CoffeeTracker {
	
	val emptyTracker = new CoffeeTracker(emptyList)

	context "overall consumption is"{

		fact "zero with zero coffee drinkers"{
			emptyTracker.overallConsumption => 0
		}
		
		fact "two with single coffee drinker with two coffees"{
			val coffeeDrinker = new CoffeeDrinker(null, 2)
			val tracker = new CoffeeTracker(list(coffeeDrinker))
			tracker.overallConsumption => 2
		}
	}
	
	context "consumption per person is"{
		
		fact "zero with zero coffee drinkers"{
			emptyTracker.consumptionOf("somebody") => 0
		}
		
		fact "coffee count of person with given name"{
			val tracker = new CoffeeTracker(list(
				new CoffeeDrinker("a", 2),
				new CoffeeDrinker("a", 2)
			))
			tracker.consumptionOf("a") => 2
		}
	}
		
}