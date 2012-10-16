package expenses

class ExpenseParser {
	def parse(Expenses expenses, String input){
		if(input == null){
			throw new IllegalArgumentException
		}
		val expenseStrings = input.split("\n")
		expenseStrings.forEach[addTo(expenses)] 
	}
	
	def addTo(String expenseString, Expenses expenses){
		val entries = expenseString.split(",").iterator.map[trim]
		val expense = new Expense(entries.next, Integer::valueOf(entries.next))
		expenses.add(expense)
	}
}