package org.jnario.enumlang.specs;

import java.util.List;
import org.jnario.lib.ExampleTableRow;

public class EnumCompilerSpecExamples extends ExampleTableRow {
  public EnumCompilerSpecExamples(final List<String> cellNames, final String input, final Class<RuntimeException> expect) {
    super(cellNames);
    this.input = input;
    this.expect = expect;
  }
  
  public String input;
  
  public String getInput() {
    return input;
  }
  
  public Class<RuntimeException> expect;
  
  public Class<RuntimeException> getExpect() {
    return expect;
  }
  
  public List<String> getCells() {
    return java.util.Arrays.asList(toString(input) ,toString(expect));
  }
}
