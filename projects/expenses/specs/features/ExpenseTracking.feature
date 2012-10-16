package features

import expenses.Expenses
import expenses.ExpenseParser

Feature: Tracking Expenses
	
	In order not to pay too much
	As a economical coffee drinker
	I want to know how much everyone has to pay
	
	Scenario: Calculating overall expenses
		Expenses expenses = new Expenses
		int result	
		Given a list of expenses
		'''
		Sebastian,20
		Birgit,20		
		'''
			new ExpenseParser().parse(expenses, args.first)
		When I calculate the overall expenses 
			result = expenses.overall
		Then the result is "40"
			result => args.first.toInt	

	Scenario: Calculating expenses per user
	
		Given a list of expenses
		'''
		Sebastian,10
		Sebastian,20
		Birgit,10
		'''		
		When I calculate the expenses of "Sebastian"
			result = expenses.of(args.first)
		Then the result is "30" 