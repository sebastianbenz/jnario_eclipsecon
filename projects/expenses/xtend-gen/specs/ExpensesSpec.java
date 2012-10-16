package specs;

import expenses.Expenses;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import specs.ExpensesOfSomebodySpec;
import specs.ExpensesOverallSpec;

@Contains({ ExpensesOverallSpec.class, ExpensesOfSomebodySpec.class })
@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("Expenses")
public class ExpensesSpec {
  Expenses expenses = new Function0<Expenses>() {
    public Expenses apply() {
      Expenses _expenses = new Expenses();
      return _expenses;
    }
  }.apply();
}
