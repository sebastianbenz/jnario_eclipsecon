import features.TrackingCoffeeConsumptionFeature;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Progress")
@Contains(TrackingCoffeeConsumptionFeature.class)
@SuppressWarnings("all")
public class ProgressSuite {
}
