package features;

import coffee.CoffeeDrinker;
import coffee.CoffeeListParser;
import coffee.CoffeeTracker;
import java.util.List;
import org.hamcrest.StringDescription;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.lib.StepArguments;
import org.jnario.lib.StringConversions;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Calculating expenses per user")
@SuppressWarnings("all")
public class TrackingCoffeeConsumptionFeatureCalculatingExpensesPerUser {
  @Test
  @Order(0)
  @Named("Given a coffee list")
  public void givenACoffeeList() {
    StepArguments _stepArguments = new StepArguments("Sebastian ||\nBirgit |||\n");
    final StepArguments args = _stepArguments;
    CoffeeListParser _coffeeListParser = new CoffeeListParser();
    String _first = JnarioIterableExtensions.<String>first(args);
    List<CoffeeDrinker> _parse = _coffeeListParser.parse(_first);
    this.coffeeDrinkers = _parse;
  }
  
  @Test
  @Order(1)
  @Named("When I calculate the coffee consumption of \\\"Sebastian\\\"")
  public void whenICalculateTheCoffeeConsumptionOfSebastian() {
    StepArguments _stepArguments = new StepArguments("Sebastian");
    final StepArguments args = _stepArguments;
    CoffeeTracker _coffeeTracker = new CoffeeTracker(this.coffeeDrinkers);
    String _first = JnarioIterableExtensions.<String>first(args);
    int _consumptionOf = _coffeeTracker.consumptionOf(_first);
    this.result = _consumptionOf;
  }
  
  @Test
  @Order(2)
  @Named("Then the result is \\\"2\\\"")
  public void thenTheResultIs2() {
    StepArguments _stepArguments = new StepArguments("2");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    int _int = StringConversions.toInt(_first);
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(this.result), Integer.valueOf(_int));
    Assert.assertTrue("\nExpected  but"
     + "\n      is " + new StringDescription().appendValue(Integer.valueOf(_int)).toString() + "\n", _doubleArrow);
    
  }
  
  List<CoffeeDrinker> coffeeDrinkers;
  
  int result;
}
