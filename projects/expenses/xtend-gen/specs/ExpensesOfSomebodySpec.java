package specs;

import expenses.Expense;
import expenses.Expenses;
import org.hamcrest.StringDescription;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import specs.ExpensesSpec;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("of somebody")
public class ExpensesOfSomebodySpec extends ExpensesSpec {
  @Test
  @Named("new Expenses[].of[\\\"unknown\\\"] should be 0")
  @Order(2)
  public void _newExpensesOfUnknownShouldBe0() throws Exception {
    Expenses _expenses = new Expenses();
    int _of = _expenses.of("unknown");
    boolean _should_be = Should.should_be(Integer.valueOf(_of), Integer.valueOf(0));
    Assert.assertTrue("\nExpected new Expenses().of(\"unknown\") should be 0 but"
     + "\n     new Expenses().of(\"unknown\") is " + new StringDescription().appendValue(Integer.valueOf(_of)).toString()
     + "\n     new Expenses() is " + new StringDescription().appendValue(_expenses).toString() + "\n", _should_be);
    
  }
  
  @Test
  @Named("all expenses of the same person")
  @Order(3)
  public void _allExpensesOfTheSamePerson() throws Exception {
    Expense _expense = new Expense("Sebastian", 10);
    this.expenses.add(_expense);
    int _of = this.expenses.of("Sebastian");
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_of), Integer.valueOf(10));
    Assert.assertTrue("\nExpected expenses.of(\"Sebastian\") => 10 but"
     + "\n     expenses.of(\"Sebastian\") is " + new StringDescription().appendValue(Integer.valueOf(_of)).toString()
     + "\n     expenses is " + new StringDescription().appendValue(this.expenses).toString() + "\n", _doubleArrow);
    
  }
}
