package specs;

import expenses.Expense;
import expenses.Expenses;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hamcrest.StringDescription;
import org.jnario.lib.ExampleTable;
import org.jnario.lib.ExampleTableIterators;
import org.jnario.lib.JnarioCollectionLiterals;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import specs.ExpensesOverallSpecExampleCalculations;
import specs.ExpensesSpec;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("overall")
public class ExpensesOverallSpec extends ExpensesSpec {
  @Test
  @Named("new Expenses[].overall should be 0")
  @Order(0)
  public void _newExpensesOverallShouldBe0() throws Exception {
    Expenses _expenses = new Expenses();
    int _overall = _expenses.overall();
    boolean _should_be = Should.should_be(Integer.valueOf(_overall), Integer.valueOf(0));
    Assert.assertTrue("\nExpected new Expenses().overall should be 0 but"
     + "\n     new Expenses().overall is " + new StringDescription().appendValue(Integer.valueOf(_overall)).toString()
     + "\n     new Expenses() is " + new StringDescription().appendValue(_expenses).toString() + "\n", _should_be);
    
  }
  
  @Before
  public void _initExpensesOverallSpecExampleCalculations() {
    
    List<Integer> _list = JnarioCollectionLiterals.<Integer>list(Integer.valueOf(10));
    List<Integer> _list_1 = JnarioCollectionLiterals.<Integer>list(Integer.valueOf(10), Integer.valueOf(1));exampleCalculations = ExampleTable.create("exampleCalculations", 
      java.util.Arrays.asList("amounts", "overall"), 
      new ExpensesOverallSpecExampleCalculations(  java.util.Arrays.asList("list(10)", "10"), _list, 10),
      new ExpensesOverallSpecExampleCalculations(  java.util.Arrays.asList("list(10,1)", "11"), _list_1, 11)
    );
  }
  
  protected ExampleTable<ExpensesOverallSpecExampleCalculations> exampleCalculations;
  
  @Test
  @Named("sum of all expenses")
  @Order(1)
  public void _sumOfAllExpenses() throws Exception {
    final Procedure1<ExpensesOverallSpecExampleCalculations> _function = new Procedure1<ExpensesOverallSpecExampleCalculations>() {
        public void apply(final ExpensesOverallSpecExampleCalculations it) {
          Expenses _expenses = new Expenses();
          ExpensesOverallSpec.this.expenses = _expenses;
          final Procedure1<Integer> _function = new Procedure1<Integer>() {
              public void apply(final Integer it) {
                String __ = Should.<String>_();
                Expense _expense = new Expense(__, (it).intValue());
                ExpensesOverallSpec.this.expenses.add(_expense);
              }
            };
          IterableExtensions.<Integer>forEach(it.amounts, _function);
          int _overall = ExpensesOverallSpec.this.expenses.overall();
          boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_overall), Integer.valueOf(it.overall));
          Assert.assertTrue("\nExpected expenses.overall => overall but"
           + "\n     expenses.overall is " + new StringDescription().appendValue(Integer.valueOf(_overall)).toString()
           + "\n     expenses is " + new StringDescription().appendValue(ExpensesOverallSpec.this.expenses).toString()
           + "\n     overall is " + new StringDescription().appendValue(Integer.valueOf(it.overall)).toString() + "\n", _doubleArrow);
          
        }
      };
    ExampleTableIterators.<ExpensesOverallSpecExampleCalculations>forEach(this.exampleCalculations, _function);
  }
}
