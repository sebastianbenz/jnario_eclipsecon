package specs

import expenses.ExpenseParser
import expenses.Expenses
import static org.mockito.Mockito.*
import expenses.Expense

/*
 * This is a simple expense parser. It does not handle invalid inputs yet.
 */
describe ExpenseParser {
	val expenses = mock(Expenses)
	
	fact "parses expenses of the form 'NAME,CATEGORY;VALUE'"{
		parse("Name,20")
		verify(expenses).add(new Expense("Name",  20))
	}
	
	fact "parses multiple expenses separated by newlines"{
		'''
			Name1,20
			Name2,30
		'''.parse
		verify(expenses).add(new Expense("Name1", 20))
		verify(expenses).add(new Expense("Name2", 30))
	}
	
	/*
	 * Whitespaces are allowed at the beginning, end and in between.
	 */
	fact "ignores white spaces"{
		'''
			   Name1,20
			Name2,30   
			Name2 , 30   
		'''.parse
		verify(expenses).add(new Expense("Name1", 20))
		verify(expenses).add(new Expense("Name2", 30))
	}
	
	fact parse(null) should throw IllegalArgumentException
	
	def parse(CharSequence input) {
		subject.parse(expenses, input?.toString)
	}
} 