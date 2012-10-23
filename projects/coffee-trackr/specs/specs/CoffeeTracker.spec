package specs

import coffee.CoffeeTracker
import coffee.CoffeeDrinker
import org.eclipse.xtext.xbase.lib.Pair

describe CoffeeTracker {
	
	val emptyTracker = new CoffeeTracker(emptyList)

	context "overall consumption is"{

		fact "zero with zero coffee drinkers"{
			emptyTracker.overallConsumption => 0
		}
		
		fact "two with single coffee drinker with two coffees"{
			val coffeeDrinker = new CoffeeDrinker(_, 2)
			val tracker = new CoffeeTracker(list(coffeeDrinker))
			tracker.overallConsumption => 2
		}
	}
	
	context "consumption per person is"{
		fact "zero with zero coffee drinkers"{
			emptyTracker.consumptionOf("somebody") => 0
		}
		
		fact "coffee count of person with given name"{
			val coffeeDrinkerA = new CoffeeDrinker("a", 2)
			val coffeeDrinkerB = new CoffeeDrinker("b", 4)
			val tracker = new CoffeeTracker(list(coffeeDrinkerA, coffeeDrinkerB))
			tracker.consumptionOf("a") => 2
		}
	}
		
}