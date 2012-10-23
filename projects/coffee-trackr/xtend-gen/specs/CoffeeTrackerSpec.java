package specs;

import coffee.CoffeeDrinker;
import coffee.CoffeeTracker;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import specs.CoffeeTrackerConsumptionPerPersonIsSpec;
import specs.CoffeeTrackerOverallConsumptionIsSpec;

@Contains({ CoffeeTrackerOverallConsumptionIsSpec.class, CoffeeTrackerConsumptionPerPersonIsSpec.class })
@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("CoffeeTracker")
public class CoffeeTrackerSpec {
  final CoffeeTracker emptyTracker = new Function0<CoffeeTracker>() {
    public CoffeeTracker apply() {
      List<CoffeeDrinker> _emptyList = CollectionLiterals.<CoffeeDrinker>emptyList();
      CoffeeTracker _coffeeTracker = new CoffeeTracker(_emptyList);
      return _coffeeTracker;
    }
  }.apply();
}
