package features;

import features.TrackingCoffeeConsumptionFeatureCalculatingExpensesPerUser;
import features.TrackingCoffeeConsumptionFeatureTrackingOverallCoffeeConsumption;
import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Contains({ TrackingCoffeeConsumptionFeatureTrackingOverallCoffeeConsumption.class, TrackingCoffeeConsumptionFeatureCalculatingExpensesPerUser.class })
@Named("Tracking Coffee Consumption")
@SuppressWarnings("all")
public class TrackingCoffeeConsumptionFeature {
}
