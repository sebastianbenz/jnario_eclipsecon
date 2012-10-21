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
@Named("consumption per person")
public class CoffeeTrackerConsumptionPerPersonSpec extends CoffeeTrackerSpec {
  @Test
  @Named("zero if person does not exist")
  @Order(3)
  public void _zeroIfPersonDoesNotExist() throws Exception {
    CoffeeTracker _coffeeList = this.coffeeList();
    int _consumptionOf = _coffeeList.consumptionOf("unknown");
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_consumptionOf), Integer.valueOf(0));
    Assert.assertTrue("\nExpected coffeeList().consumptionOf(\"unknown\") => 0 but"
     + "\n     coffeeList().consumptionOf(\"unknown\") is " + new StringDescription().appendValue(Integer.valueOf(_consumptionOf)).toString()
     + "\n     coffeeList() is " + new StringDescription().appendValue(_coffeeList).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("one if the person had one coffee")
  @Order(4)
  public void _oneIfThePersonHadOneCoffee() throws Exception {
    Pair<String,Integer> _mappedTo = Pair.<String, Integer>of("Sebastian", Integer.valueOf(1));
    CoffeeTracker _coffeeList = this.coffeeList(_mappedTo);
    int _consumptionOf = _coffeeList.consumptionOf("Sebastian");
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_consumptionOf), Integer.valueOf(1));
    Assert.assertTrue("\nExpected coffeeList(\"Sebastian\" -> 1).consumptionOf(\"Sebastian\") => 1 but"
     + "\n     coffeeList(\"Sebastian\" -> 1).consumptionOf(\"Sebastian\") is " + new StringDescription().appendValue(Integer.valueOf(_consumptionOf)).toString()
     + "\n     coffeeList(\"Sebastian\" -> 1) is " + new StringDescription().appendValue(_coffeeList).toString()
     + "\n     \"Sebastian\" -> 1 is " + new StringDescription().appendValue(_mappedTo).toString() + "\n", _doubleArrow);
    
  }
}
