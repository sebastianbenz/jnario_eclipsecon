import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Tracking Expenses")
@Contains({ FeaturesSuite.class, SpecsSuite.class })
@SuppressWarnings("all")
public class TrackingExpensesSuite {
}
