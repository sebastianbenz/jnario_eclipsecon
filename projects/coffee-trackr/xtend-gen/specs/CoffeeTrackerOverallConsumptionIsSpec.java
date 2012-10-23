package specs;

import coffee.CoffeeDrinker;
import coffee.CoffeeTracker;
import java.util.List;
import org.hamcrest.StringDescription;
import org.jnario.lib.JnarioCollectionLiterals;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import specs.CoffeeTrackerSpec;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("overall consumption is")
public class CoffeeTrackerOverallConsumptionIsSpec extends CoffeeTrackerSpec {
  @Test
  @Named("zero with zero coffee drinkers")
  @Order(0)
  public void _zeroWithZeroCoffeeDrinkers() throws Exception {
    int _overallConsumption = this.emptyTracker.overallConsumption();
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_overallConsumption), Integer.valueOf(0));
    Assert.assertTrue("\nExpected emptyTracker.overallConsumption => 0 but"
     + "\n     emptyTracker.overallConsumption is " + new StringDescription().appendValue(Integer.valueOf(_overallConsumption)).toString()
     + "\n     emptyTracker is " + new StringDescription().appendValue(this.emptyTracker).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("two with single coffee drinker with two coffees")
  @Order(1)
  public void _twoWithSingleCoffeeDrinkerWithTwoCoffees() throws Exception {
    String __ = Should.<String>_();
    CoffeeDrinker _coffeeDrinker = new CoffeeDrinker(__, 2);
    final CoffeeDrinker coffeeDrinker = _coffeeDrinker;
    List<CoffeeDrinker> _list = JnarioCollectionLiterals.<CoffeeDrinker>list(coffeeDrinker);
    CoffeeTracker _coffeeTracker = new CoffeeTracker(_list);
    final CoffeeTracker tracker = _coffeeTracker;
    int _overallConsumption = tracker.overallConsumption();
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_overallConsumption), Integer.valueOf(2));
    Assert.assertTrue("\nExpected tracker.overallConsumption => 2 but"
     + "\n     tracker.overallConsumption is " + new StringDescription().appendValue(Integer.valueOf(_overallConsumption)).toString()
     + "\n     tracker is " + new StringDescription().appendValue(tracker).toString() + "\n", _doubleArrow);
    
  }
}
