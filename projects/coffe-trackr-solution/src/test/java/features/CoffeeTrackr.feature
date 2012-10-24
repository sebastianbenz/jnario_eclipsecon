
package features

import coffee.CoffeeDrinker
import coffee.CoffeeListParser
import coffee.CoffeeTracker
import java.util.List

import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*
import static extension org.jnario.lib.StringConversions.*

Feature: Tracking Coffee Consumption

	In order to manage our coffee expenses
	as developers with constant need of caffeine
	we want a coffee tracking tool.
	
	Background:
		List<CoffeeDrinker> coffeeDrinkers 
		CoffeeTracker coffeeTracker
		Given a coffee list
			'''
				Sebastian	|||
				Birgit 		||
			'''
			val coffeListParser = new CoffeeListParser()
			coffeeDrinkers = coffeListParser.parse(args.first)
		And a coffee tracker
				coffeeTracker = new CoffeeTracker(coffeeDrinkers)
	
	Scenario: Tracking overall coffee consumption
		int result	
		When I calculate the overall coffee consumption  
			result = coffeeTracker.overallConsumption
		Then the result is "5" 
			result => args.first.toInt	


	Scenario: Tracking coffee consumption per person
	
		When I calculate the coffee consumption of "Sebastian"
			result = coffeeTracker.consumptionOf(args.first)
		Then the result is "3" 
		