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
@Named("Scenario: Calculating overall expenses")
@SuppressWarnings("all")
public class TrackingExpensesFeatureCalculatingOverallExpenses {
  @Test
  @Order(0)
  @Named("Given a list of expenses")
  public void givenAListOfExpenses() {
    StepArguments _stepArguments = new StepArguments("Sebastian,20\nBirgit,20\t\t\n");
    final StepArguments args = _stepArguments;
    ExpenseParser _expenseParser = new ExpenseParser();
    String _first = JnarioIterableExtensions.<String>first(args);
    _expenseParser.parse(this.expenses, _first);
  }
  
  @Test
  @Order(1)
  @Named("When I calculate the overall expenses")
  public void whenICalculateTheOverallExpenses() {
    int _overall = this.expenses.overall();
    this.result = _overall;
  }
  
  @Test
  @Order(2)
  @Named("Then the result is \\\"40\\\"")
  public void thenTheResultIs40() {
    StepArguments _stepArguments = new StepArguments("40");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    int _int = StringConversions.toInt(_first);
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(this.result), Integer.valueOf(_int));
    Assert.assertTrue("\nExpected result => args.first.toInt but"
     + "\n     result is " + new StringDescription().appendValue(Integer.valueOf(this.result)).toString()
     + "\n     args.first.toInt is " + new StringDescription().appendValue(Integer.valueOf(_int)).toString()
     + "\n     args.first is " + new StringDescription().appendValue(_first).toString()
     + "\n     args is " + new StringDescription().appendValue(args).toString() + "\n", _doubleArrow);
    
  }
  
  Expenses expenses = new Function0<Expenses>() {
    public Expenses apply() {
      Expenses _expenses = new Expenses();
      return _expenses;
    }
  }.apply();
  
  int result;
}
