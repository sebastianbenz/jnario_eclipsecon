package specs;

import java.util.List;
import org.jnario.lib.ExampleTableRow;

public class CoffeeListParserSpecExamples extends ExampleTableRow {
  public CoffeeListParserSpecExamples(final List<String> cellNames, final String input, final String name, final int count) {
    super(cellNames);
    this.input = input;
    this.name = name;
    this.count = count;
  }
  
  public String input;
  
  public String getInput() {
    return input;
  }
  
  public String name;
  
  public String getName() {
    return name;
  }
  
  public int count;
  
  public int getCount() {
    return count;
  }
  
  public List<String> getCells() {
    return java.util.Arrays.asList(toString(input) ,toString(name) ,toString(count));
  }
}
