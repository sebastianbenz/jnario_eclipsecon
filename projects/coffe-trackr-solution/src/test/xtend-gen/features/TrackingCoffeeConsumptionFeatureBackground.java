package features;

import coffee.CoffeeDrinker;
import coffee.CoffeeListParser;
import coffee.CoffeeTracker;
import java.util.List;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Background:")
@SuppressWarnings("all")
public class TrackingCoffeeConsumptionFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a coffee list")
  public void givenACoffeeList() {
    StepArguments _stepArguments = new StepArguments("Sebastian\t|||\nBirgit \t\t||\n\t\t\t");
    final StepArguments args = _stepArguments;
    CoffeeListParser _coffeeListParser = new CoffeeListParser();
    final CoffeeListParser coffeListParser = _coffeeListParser;
    String _first = JnarioIterableExtensions.<String>first(args);
    List<CoffeeDrinker> _parse = coffeListParser.parse(_first);
    this.coffeeDrinkers = _parse;
  }
  
  @Test
  @Order(1)
  @Named("And a coffee tracker")
  public void andACoffeeTracker() {
    CoffeeTracker _coffeeTracker = new CoffeeTracker(this.coffeeDrinkers);
    this.coffeeTracker = _coffeeTracker;
  }
  
  List<CoffeeDrinker> coffeeDrinkers;
  
  CoffeeTracker coffeeTracker;
}
