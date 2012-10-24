package features;

import features.TrackingCoffeeConsumptionFeatureBackground;
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
@Named("Scenario: Tracking coffee consumption per person")
@SuppressWarnings("all")
public class TrackingCoffeeConsumptionFeatureTrackingCoffeeConsumptionPerPerson extends TrackingCoffeeConsumptionFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a coffee list")
  public void givenACoffeeList() {
    super.givenACoffeeList();
  }
  
  @Test
  @Order(1)
  @Named("And a coffee tracker")
  public void andACoffeeTracker() {
    super.andACoffeeTracker();
  }
  
  @Test
  @Order(2)
  @Named("When I calculate the coffee consumption of \\\"Sebastian\\\"")
  public void whenICalculateTheCoffeeConsumptionOfSebastian() {
    StepArguments _stepArguments = new StepArguments("Sebastian");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    int _consumptionOf = this.coffeeTracker.consumptionOf(_first);
    this.result = _consumptionOf;
  }
  
  @Test
  @Order(3)
  @Named("Then the result is \\\"3\\\"")
  public void thenTheResultIs3() {
    StepArguments _stepArguments = new StepArguments("3");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    int _int = StringConversions.toInt(_first);
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(this.result), Integer.valueOf(_int));
    Assert.assertTrue("\nExpected  but"
     + "\n      is " + new StringDescription().appendValue(Integer.valueOf(_int)).toString() + "\n", _doubleArrow);
    
  }
  
  int result;
}
