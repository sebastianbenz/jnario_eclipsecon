package specs;

import java.util.List;
import org.jnario.lib.ExampleTableRow;

public class CoffeeListParserSpecCoffeeDrinkers extends ExampleTableRow {
  public CoffeeListParserSpecCoffeeDrinkers(final List<String> cellNames, final String coffeList, final String expectedName, final int expectedCoffeeCount) {
    super(cellNames);
    this.coffeList = coffeList;
    this.expectedName = expectedName;
    this.expectedCoffeeCount = expectedCoffeeCount;
  }
  
  public String coffeList;
  
  public String getCoffeList() {
    return coffeList;
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
    return java.util.Arrays.asList(toString(coffeList) ,toString(expectedName) ,toString(expectedCoffeeCount));
  }
}
