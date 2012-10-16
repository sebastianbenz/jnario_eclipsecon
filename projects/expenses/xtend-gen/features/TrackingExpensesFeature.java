package features;

import features.TrackingExpensesFeatureCalculatingExpensesPerUser;
import features.TrackingExpensesFeatureCalculatingOverallExpenses;
import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Contains({ TrackingExpensesFeatureCalculatingOverallExpenses.class, TrackingExpensesFeatureCalculatingExpensesPerUser.class })
@Named("Tracking Expenses")
@SuppressWarnings("all")
public class TrackingExpensesFeature {
}
