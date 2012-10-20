import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import specs.CoffeeListParserSpec;
import specs.CoffeeTrackerSpec;

@RunWith(ExampleGroupRunner.class)
@Named("Regression")
@Contains({ CoffeeListParserSpec.class, CoffeeTrackerSpec.class })
@SuppressWarnings("all")
public class RegressionSuite {
}
