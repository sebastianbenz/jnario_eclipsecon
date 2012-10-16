package features;

import expenses.ExpenseParser;
import expenses.Expenses;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.hamcrest.StringDescription;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.lib.StepArguments;
import org.jnario.lib.StringConversions;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Calculating expenses per user")
@SuppressWarnings("all")
public class TrackingExpensesFeatureCalculatingExpensesPerUser {
  @Test
  @Order(0)
  @Named("Given a list of expenses")
  public void givenAListOfExpenses() {
    StepArguments _stepArguments = new StepArguments("Sebastian,10\nSebastian,20\nBirgit,10\n");
    final StepArguments args = _stepArguments;
    ExpenseParser _expenseParser = new ExpenseParser();
    String _first = JnarioIterableExtensions.<String>first(args);
    _expenseParser.parse(this.expenses, _first);
  }
  
  @Test
  @Order(1)
  @Named("When I calculate the expenses of \\\"Sebastian\\\"")
  public void whenICalculateTheExpensesOfSebastian() {
    StepArguments _stepArguments = new StepArguments("Sebastian");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    int _of = this.expenses.of(_first);
    this.result = _of;
  }
  
  @Test
  @Order(2)
  @Named("Then the result is \\\"30\\\"")
  public void thenTheResultIs30() {
    StepArguments _stepArguments = new StepArguments("30");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    int _int = StringConversions.toInt(_first);
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(this.result), Integer.valueOf(_int));
    Assert.assertTrue("\nExpected  but"
     + "\n      is " + new StringDescription().appendValue(Integer.valueOf(_int)).toString() + "\n", _doubleArrow);
    
  }
  
  Expenses expenses = new Function0<Expenses>() {
    public Expenses apply() {
      Expenses _expenses = new Expenses();
      return _expenses;
    }
  }.apply();
  
  int result;
}
