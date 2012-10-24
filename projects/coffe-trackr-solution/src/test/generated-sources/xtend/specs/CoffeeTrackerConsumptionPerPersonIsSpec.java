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
@Named("consumption per person is")
public class CoffeeTrackerConsumptionPerPersonIsSpec extends CoffeeTrackerSpec {
  @Test
  @Named("zero with zero coffee drinkers")
  @Order(2)
  public void _zeroWithZeroCoffeeDrinkers() throws Exception {
    int _consumptionOf = this.emptyTracker.consumptionOf("somebody");
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_consumptionOf), Integer.valueOf(0));
    Assert.assertTrue("\nExpected emptyTracker.consumptionOf(\"somebody\") => 0 but"
     + "\n     emptyTracker.consumptionOf(\"somebody\") is " + new StringDescription().appendValue(Integer.valueOf(_consumptionOf)).toString()
     + "\n     emptyTracker is " + new StringDescription().appendValue(this.emptyTracker).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("coffee count of person with given name")
  @Order(3)
  public void _coffeeCountOfPersonWithGivenName() throws Exception {
    CoffeeDrinker _coffeeDrinker = new CoffeeDrinker("a", 2);
    CoffeeDrinker _coffeeDrinker_1 = new CoffeeDrinker("a", 2);
    List<CoffeeDrinker> _list = JnarioCollectionLiterals.<CoffeeDrinker>list(_coffeeDrinker, _coffeeDrinker_1);
    CoffeeTracker _coffeeTracker = new CoffeeTracker(_list);
    final CoffeeTracker tracker = _coffeeTracker;
    int _consumptionOf = tracker.consumptionOf("a");
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_consumptionOf), Integer.valueOf(2));
    Assert.assertTrue("\nExpected tracker.consumptionOf(\"a\") => 2 but"
     + "\n     tracker.consumptionOf(\"a\") is " + new StringDescription().appendValue(Integer.valueOf(_consumptionOf)).toString()
     + "\n     tracker is " + new StringDescription().appendValue(tracker).toString() + "\n", _doubleArrow);
    
  }
}
