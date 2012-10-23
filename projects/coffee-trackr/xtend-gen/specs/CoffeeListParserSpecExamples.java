package specs;

import java.util.List;
import org.jnario.lib.ExampleTableRow;

public class CoffeeListParserSpecExamples extends ExampleTableRow {
  public CoffeeListParserSpecExamples(final List<String> cellNames, final String input, final String expectedName, final int expectedCoffeeCount) {
    super(cellNames);
    this.input = input;
    this.expectedName = expectedName;
    this.expectedCoffeeCount = expectedCoffeeCount;
  }
  
  public String input;
  
  public String getInput() {
    return input;
  }
  
  public String expectedName;
  
  public String getExpectedName() {
    return expectedName;
  }
  
  public int expectedCoffeeCount;
  
  public int getExpectedCoffeeCount() {
    return expectedCoffeeCount;
  }
  
  public List<String> getCells() {
    return java.util.Arrays.asList(toString(input) ,toString(expectedName) ,toString(expectedCoffeeCount));
  }
}
