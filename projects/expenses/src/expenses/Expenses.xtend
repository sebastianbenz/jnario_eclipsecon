package expenses

import com.google.common.collect.HashMultimap

class Expenses {
	
	var sum = 0
	val expenses2Name = HashMultimap::<String, Integer>create
	
	def overall(){
		return sum
	}
	def add(Expense expense){
		sum = sum + expense.value
		expenses2Name.put(expense.name, expense.value)
	}
	
	def of(String name){
		val expenses = expenses2Name.get(name)
		if(expenses.empty){
			return 0
		}
		expenses.reduce[a, b | a + b] 
	}
	
}