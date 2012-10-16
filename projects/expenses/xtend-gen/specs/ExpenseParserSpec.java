package specs;

import expenses.Expense;
import expenses.ExpenseParser;
import expenses.Expenses;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.runner.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 * This is a simple expense parser. It does not handle invalid inputs yet.
 */
@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("ExpenseParser")
public class ExpenseParserSpec {
  @Subject
  public ExpenseParser subject;
  
  final Expenses expenses = Mockito.mock(Expenses.class);
  
  @Test
  @Named("parses expenses of the form \\\'NAME,CATEGORY;VALUE\\\'")
  @Order(0)
  public void _parsesExpensesOfTheFormNAMECATEGORYVALUE() throws Exception {
    this.parse("Name,20");
    Expenses _verify = Mockito.<Expenses>verify(this.expenses);
    Expense _expense = new Expense("Name", 20);
    _verify.add(_expense);
  }
  
  @Test
  @Named("parses multiple expenses separated by newlines")
  @Order(1)
  public void _parsesMultipleExpensesSeparatedByNewlines() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Name1,20");
    _builder.newLine();
    _builder.append("Name2,30");
    _builder.newLine();
    this.parse(_builder);
    Expenses _verify = Mockito.<Expenses>verify(this.expenses);
    Expense _expense = new Expense("Name1", 20);
    _verify.add(_expense);
    Expenses _verify_1 = Mockito.<Expenses>verify(this.expenses);
    Expense _expense_1 = new Expense("Name2", 30);
    _verify_1.add(_expense_1);
  }
  
  /**
   * Whitespaces are allowed at the beginning, end and in between.
   */
  @Test
  @Named("ignores white spaces")
  @Order(2)
  public void _ignoresWhiteSpaces() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    _builder.append("Name1,20");
    _builder.newLine();
    _builder.append("Name2,30   ");
    _builder.newLine();
    _builder.append("Name2 , 30   ");
    _builder.newLine();
    this.parse(_builder);
    Expenses _verify = Mockito.<Expenses>verify(this.expenses);
    Expense _expense = new Expense("Name1", 20);
    _verify.add(_expense);
    Expenses _verify_1 = Mockito.<Expenses>verify(this.expenses);
    Expense _expense_1 = new Expense("Name2", 30);
    _verify_1.add(_expense_1);
  }
  
  @Test
  @Named("parse[null] should throw IllegalArgumentException")
  @Order(3)
  public void _parseNullShouldThrowIllegalArgumentException() throws Exception {
    try{
      this.parse(null);
      Assert.fail("Expected " + IllegalArgumentException.class.getName() + " in \n     parse(null)\n with:");
    }catch(IllegalArgumentException e){
      // expected
    }
  }
  
  public void parse(final CharSequence input) {
    String _string = input==null?(String)null:input.toString();
    this.subject.parse(this.expenses, _string);
  }
}
