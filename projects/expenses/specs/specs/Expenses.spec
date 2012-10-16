package specs

import expenses.Expenses
import expenses.Expense

describe Expenses {
	var expenses = new Expenses

	describe "overall"{
		
		fact new Expenses().overall should be 0
		
		def exampleCalculations{
			| amounts 		| overall |
			| list(10)		| 10	  |
			| list(10,1)	| 11	  |
		}
		
		fact "sum of all expenses"{
			exampleCalculations.forEach[
				expenses = new Expenses
				amounts.forEach[
					expenses.add(new Expense(_,it))
				]
				expenses.overall => overall
			]
		}
	}
	
	describe "of somebody"{
		fact new Expenses().of("unknown") should be 0
		
		fact "all expenses of the same person"{
			expenses.add(new Expense("Sebastian", 10))
			expenses.of("Sebastian") => 10
		}
	}
}