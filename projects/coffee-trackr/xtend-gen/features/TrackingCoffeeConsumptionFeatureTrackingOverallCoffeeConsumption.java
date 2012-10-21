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
@Named("Scenario: Tracking overall coffee consumption")
@SuppressWarnings("all")
public class TrackingCoffeeConsumptionFeatureTrackingOverallCoffeeConsumption {
  @Test
  @Order(0)
  @Named("Given a coffee list")
  public void givenACoffeeList() {
    StepArguments _stepArguments = new StepArguments("Sebastian\t|||\nBirgit \t\t||\n\t\t\t\t\t");
    final StepArguments args = _stepArguments;
    CoffeeListParser _coffeeListParser = new CoffeeListParser();
    final CoffeeListParser coffeListParser = _coffeeListParser;
    String _first = JnarioIterableExtensions.<String>first(args);
    List<CoffeeDrinker> _parse = coffeListParser.parse(_first);
    this.coffeeDrinkers = _parse;
  }
  
  @Test
  @Order(1)
  @Named("When I calculate the overall coffee consumption")
  public void whenICalculateTheOverallCoffeeConsumption() {
    CoffeeTracker _coffeeTracker = new CoffeeTracker(this.coffeeDrinkers);
    final CoffeeTracker coffeeTracker = _coffeeTracker;
    Integer _overallConsumption = coffeeTracker.overallConsumption();
    this.result = (_overallConsumption).intValue();
  }
  
  @Test
  @Order(2)
  @Named("Then the result is \\\"5\\\"")
  public void thenTheResultIs5() {
    StepArguments _stepArguments = new StepArguments("5");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    int _int = StringConversions.toInt(_first);
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(this.result), Integer.valueOf(_int));
    Assert.assertTrue("\nExpected result => args.first.toInt but"
     + "\n     result is " + new StringDescription().appendValue(Integer.valueOf(this.result)).toString()
     + "\n     args.first.toInt is " + new StringDescription().appendValue(Integer.valueOf(_int)).toString()
     + "\n     args.first is " + new StringDescription().appendValue(_first).toString()
     + "\n     args is " + new StringDescription().appendValue(args).toString() + "\n", _doubleArrow);
    
  }
  
  List<CoffeeDrinker> coffeeDrinkers;
  
  int result;
}
