import features.TrackingExpensesFeature;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Features")
@Contains(TrackingExpensesFeature.class)
@SuppressWarnings("all")
public class FeaturesSuite {
}
