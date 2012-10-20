package specs;

import java.util.List;
import org.jnario.lib.ExampleTableRow;

public class CoffeeListParserSpecCoffeeDrinkers extends ExampleTableRow {
  public CoffeeListParserSpecCoffeeDrinkers(final List<String> cellNames, final String input, final String expectedName, final int expectedCount) {
    super(cellNames);
    this.input = input;
    this.expectedName = expectedName;
    this.expectedCount = expectedCount;
  }
  
  public String input;
  
  public String getInput() {
    return input;
  }
  
  public String expectedName;
  
  public String getExpectedName() {
    return expectedName;
  }
  
  public int expectedCount;
  
  public int getExpectedCount() {
    return expectedCount;
  }
  
  public List<String> getCells() {
    return java.util.Arrays.asList(toString(input) ,toString(expectedName) ,toString(expectedCount));
  }
}
