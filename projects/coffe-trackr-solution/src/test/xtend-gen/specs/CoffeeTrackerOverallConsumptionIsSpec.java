package specs;

import coffee.CoffeeTracker;
import org.eclipse.xtext.xbase.lib.Pair;
import org.hamcrest.StringDescription;
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
@Named("Overall consumption is")
public class CoffeeTrackerOverallConsumptionIsSpec extends CoffeeTrackerSpec {
  @Test
  @Named("Zero with zero coffee drinkers")
  @Order(0)
  public void _zeroWithZeroCoffeeDrinkers() throws Exception {
    CoffeeTracker _coffeeDrinkers = this.coffeeDrinkers();
    int _overallConsumption = _coffeeDrinkers.overallConsumption();
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_overallConsumption), Integer.valueOf(0));
    Assert.assertTrue("\nExpected coffeeDrinkers().overallConsumption => 0 but"
     + "\n     coffeeDrinkers().overallConsumption is " + new StringDescription().appendValue(Integer.valueOf(_overallConsumption)).toString()
     + "\n     coffeeDrinkers() is " + new StringDescription().appendValue(_coffeeDrinkers).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("Two with single coffee drinker with two coffees")
  @Order(1)
  public void _twoWithSingleCoffeeDrinkerWithTwoCoffees() throws Exception {
    Pair<String,Integer> _mappedTo = Pair.<String, Integer>of("Sebastian", Integer.valueOf(2));
    CoffeeTracker _coffeeDrinkers = this.coffeeDrinkers(_mappedTo);
    int _overallConsumption = _coffeeDrinkers.overallConsumption();
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_overallConsumption), Integer.valueOf(2));
    Assert.assertTrue("\nExpected coffeeDrinkers(\"Sebastian\" -> 2).overallConsumption => 2 but"
     + "\n     coffeeDrinkers(\"Sebastian\" -> 2).overallConsumption is " + new StringDescription().appendValue(Integer.valueOf(_overallConsumption)).toString()
     + "\n     coffeeDrinkers(\"Sebastian\" -> 2) is " + new StringDescription().appendValue(_coffeeDrinkers).toString()
     + "\n     \"Sebastian\" -> 2 is " + new StringDescription().appendValue(_mappedTo).toString() + "\n", _doubleArrow);
    
  }
}
