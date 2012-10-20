package features

import coffee.CoffeeDrinker
import coffee.CoffeeListParser
import coffee.CoffeeTracker
import java.util.List

import static extension org.jnario.lib.JnarioIterableExtensions.*
import static extension org.jnario.lib.Should.*
import static extension org.jnario.lib.StringConversions.*

Feature: Tracking Coffee Consumption

	In order not to pay too much
	as coffee drinking developers
	we want to know how much coffee everyone had.
	
	Scenario: Tracking overall Coffee Consumption
		List<CoffeeDrinker> coffeeDrinkers 
		int result	
		Given a coffee list
		'''
		Sebastian	|||
		Birgit 		||
		'''
			coffeeDrinkers = new CoffeeListParser().parse(args.first)
		When I calculate the overall coffee consumption 
			result = new CoffeeTracker(coffeeDrinkers).overallConsumption
		Then the result is "5"
			result => args.first.toInt	

	Scenario: Calculating expenses per user
	
		Given a coffee list
		'''
		Sebastian ||
		Birgit |||
		'''		
		When I calculate the coffee consumption of "Sebastian"
			result = new CoffeeTracker(coffeeDrinkers).consumptionOf(args.first)
		Then the result is "2" 