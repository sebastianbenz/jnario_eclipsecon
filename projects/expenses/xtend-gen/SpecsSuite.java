import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import specs.ExpenseParserSpec;
import specs.ExpensesSpec;

@RunWith(ExampleGroupRunner.class)
@Named("Specs")
@Contains({ ExpenseParserSpec.class, ExpensesSpec.class })
@SuppressWarnings("all")
public class SpecsSuite {
}
