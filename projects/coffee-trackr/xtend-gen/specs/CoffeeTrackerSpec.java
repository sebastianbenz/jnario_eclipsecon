package specs;

import coffee.CoffeeDrinker;
import coffee.CoffeeTracker;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import specs.CoffeeTrackerConsumptionPerPersonSpec;
import specs.CoffeeTrackerOverallConsumptionIsSpec;

@Contains({ CoffeeTrackerOverallConsumptionIsSpec.class, CoffeeTrackerConsumptionPerPersonSpec.class })
@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("CoffeeTracker")
public class CoffeeTrackerSpec {
  public CoffeeTracker coffeeList(final Pair<String,Integer>... coffeeDrinkers) {
    final Function1<Pair<String,Integer>,CoffeeDrinker> _function = new Function1<Pair<String,Integer>,CoffeeDrinker>() {
        public CoffeeDrinker apply(final Pair<String,Integer> it) {
          String _key = it.getKey();
          Integer _value = it.getValue();
          CoffeeDrinker _coffeeDrinker = new CoffeeDrinker(_key, (_value).intValue());
          return _coffeeDrinker;
        }
      };
    List<CoffeeDrinker> _map = ListExtensions.<Pair<String,Integer>, CoffeeDrinker>map(((List<Pair<String,Integer>>)Conversions.doWrapArray(coffeeDrinkers)), _function);
    CoffeeTracker _coffeeTracker = new CoffeeTracker(_map);
    return _coffeeTracker;
  }
}
