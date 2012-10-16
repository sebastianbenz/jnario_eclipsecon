package specs;

import java.util.List;
import org.jnario.lib.ExampleTableRow;

public class ExpensesOverallSpecExampleCalculations extends ExampleTableRow {
  public ExpensesOverallSpecExampleCalculations(final List<String> cellNames, final List<Integer> amounts, final int overall) {
    super(cellNames);
    this.amounts = amounts;
    this.overall = overall;
  }
  
  public List<Integer> amounts;
  
  public List<Integer> getAmounts() {
    return amounts;
  }
  
  public int overall;
  
  public int getOverall() {
    return overall;
  }
  
  public List<String> getCells() {
    return java.util.Arrays.asList(toString(amounts) ,toString(overall));
  }
}
