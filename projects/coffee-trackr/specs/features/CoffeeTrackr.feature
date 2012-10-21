package features

import coffee.CoffeeDrinker
import coffee.CoffeeListParser
import coffee.CoffeeTracker
import java.util.List

import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*
import static extension org.jnario.lib.StringConversions.*
	
			Feature: Tracking Coffee Consumption
			
				In order keep track of coffee consumption
				as a developer
				I want a simple coffee tracking tool.
				
				Scenario: Tracking overall coffee consumption
					List<CoffeeDrinker> coffeeDrinkers 
					int result	
			
				Given a coffee list
					'''
						Sebastian	|||
						Birgit 		||
					'''
					val coffeListParser = new CoffeeListParser()
					coffeeDrinkers = coffeListParser.parse(args.first)
					
				When I calculate the overall coffee consumption  
					val coffeeTracker = new CoffeeTracker(coffeeDrinkers)
					result = coffeeTracker.overallConsumption
					
				Then the result is "5" 
					result => args.first.toInt	


	Scenario: Tracking coffee consumption per person
	
		Given a coffee list
			'''
				Sebastian ||
				Birgit |||
			'''		
		When I calculate the coffee consumption of "Sebastian"
			val coffeeTracker = new CoffeeTracker(coffeeDrinkers)
			result = coffeeTracker.consumptionOf(args.first)
		Then the result is "2" 