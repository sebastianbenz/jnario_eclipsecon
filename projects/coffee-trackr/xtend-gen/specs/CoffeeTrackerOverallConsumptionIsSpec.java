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
@Named("overall consumption is")
public class CoffeeTrackerOverallConsumptionIsSpec extends CoffeeTrackerSpec {
  @Test
  @Named("zero if nobody drinks coffee")
  @Order(0)
  public void _zeroIfNobodyDrinksCoffee() throws Exception {
    CoffeeTracker _coffeeList = this.coffeeList();
    Integer _overallConsumption = _coffeeList.overallConsumption();
    boolean _doubleArrow = Should.operator_doubleArrow(_overallConsumption, Integer.valueOf(0));
    Assert.assertTrue("\nExpected coffeeList().overallConsumption => 0 but"
     + "\n     coffeeList().overallConsumption is " + new StringDescription().appendValue(_overallConsumption).toString()
     + "\n     coffeeList() is " + new StringDescription().appendValue(_coffeeList).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("one if a single person drinks one coffee")
  @Order(1)
  public void _oneIfASinglePersonDrinksOneCoffee() throws Exception {
    Pair<String,Integer> _mappedTo = Pair.<String, Integer>of("Sebastian", Integer.valueOf(1));
    CoffeeTracker _coffeeList = this.coffeeList(_mappedTo);
    Integer _overallConsumption = _coffeeList.overallConsumption();
    boolean _doubleArrow = Should.operator_doubleArrow(_overallConsumption, Integer.valueOf(1));
    Assert.assertTrue("\nExpected coffeeList(\"Sebastian\" -> 1).overallConsumption => 1 but"
     + "\n     coffeeList(\"Sebastian\" -> 1).overallConsumption is " + new StringDescription().appendValue(_overallConsumption).toString()
     + "\n     coffeeList(\"Sebastian\" -> 1) is " + new StringDescription().appendValue(_coffeeList).toString()
     + "\n     \"Sebastian\" -> 1 is " + new StringDescription().appendValue(_mappedTo).toString() + "\n", _doubleArrow);
    
  }
}
