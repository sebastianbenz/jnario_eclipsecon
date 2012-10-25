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
@Named("Consumption per person is")
public class CoffeeTrackerConsumptionPerPersonIsSpec extends CoffeeTrackerSpec {
  @Test
  @Named("Zero with zero coffee drinkers")
  @Order(2)
  public void _zeroWithZeroCoffeeDrinkers() throws Exception {
    CoffeeTracker _coffeeDrinkers = this.coffeeDrinkers();
    int _consumptionOf = _coffeeDrinkers.consumptionOf("somebody");
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_consumptionOf), Integer.valueOf(0));
    Assert.assertTrue("\nExpected coffeeDrinkers().consumptionOf(\"somebody\") => 0 but"
     + "\n     coffeeDrinkers().consumptionOf(\"somebody\") is " + new StringDescription().appendValue(Integer.valueOf(_consumptionOf)).toString()
     + "\n     coffeeDrinkers() is " + new StringDescription().appendValue(_coffeeDrinkers).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("Coffee count of person with given name")
  @Order(3)
  public void _coffeeCountOfPersonWithGivenName() throws Exception {
    Pair<String,Integer> _mappedTo = Pair.<String, Integer>of("Sebastian", Integer.valueOf(3));
    Pair<String,Integer> _mappedTo_1 = Pair.<String, Integer>of("Birgit", Integer.valueOf(2));
    CoffeeTracker _coffeeDrinkers = this.coffeeDrinkers(_mappedTo, _mappedTo_1);
    int _consumptionOf = _coffeeDrinkers.consumptionOf("Birgit");
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_consumptionOf), Integer.valueOf(2));
    Assert.assertTrue("\nExpected coffeeDrinkers(\n\t\t\t\t\"Sebastian\" -> 3,\n\t\t\t\t\"Birgit\" -> 2\n\t\t\t).consumptionOf(\"Birgit\") => 2 but"
     + "\n     coffeeDrinkers(\n\t\t\t\t\"Sebastian\" -> 3,\n\t\t\t\t\"Birgit\" -> 2\n\t\t\t).consumptionOf(\"Birgit\") is " + new StringDescription().appendValue(Integer.valueOf(_consumptionOf)).toString()
     + "\n     coffeeDrinkers(\n\t\t\t\t\"Sebastian\" -> 3,\n\t\t\t\t\"Birgit\" -> 2\n\t\t\t) is " + new StringDescription().appendValue(_coffeeDrinkers).toString()
     + "\n     \"Sebastian\" -> 3 is " + new StringDescription().appendValue(_mappedTo).toString()
     + "\n     \"Birgit\" -> 2 is " + new StringDescription().appendValue(_mappedTo_1).toString() + "\n", _doubleArrow);
    
  }
}
