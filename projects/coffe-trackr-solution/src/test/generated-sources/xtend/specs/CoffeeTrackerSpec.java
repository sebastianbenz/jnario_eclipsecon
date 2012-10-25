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
import specs.CoffeeTrackerConsumptionPerPersonIsSpec;
import specs.CoffeeTrackerOverallConsumptionIsSpec;

/**
 * This is our coffee calculation engine.
 */
@Contains({ CoffeeTrackerOverallConsumptionIsSpec.class, CoffeeTrackerConsumptionPerPersonIsSpec.class })
@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("CoffeeTracker")
public class CoffeeTrackerSpec {
  public CoffeeTracker coffeeDrinkers(final Pair<String,Integer>... params) {
    CoffeeTracker _xblockexpression = null;
    {
      final Function1<Pair<String,Integer>,CoffeeDrinker> _function = new Function1<Pair<String,Integer>,CoffeeDrinker>() {
          public CoffeeDrinker apply(final Pair<String,Integer> it) {
            String _key = it.getKey();
            Integer _value = it.getValue();
            CoffeeDrinker _coffeeDrinker = new CoffeeDrinker(_key, (_value).intValue());
            return _coffeeDrinker;
          }
        };
      final List<CoffeeDrinker> coffeeDrinkers = ListExtensions.<Pair<String,Integer>, CoffeeDrinker>map(((List<Pair<String,Integer>>)Conversions.doWrapArray(params)), _function);
      CoffeeTracker _coffeeTracker = new CoffeeTracker(coffeeDrinkers);
      _xblockexpression = (_coffeeTracker);
    }
    return _xblockexpression;
  }
}
