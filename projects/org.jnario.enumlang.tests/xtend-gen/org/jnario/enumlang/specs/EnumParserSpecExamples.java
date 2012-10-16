package org.jnario.enumlang.specs;

import java.util.List;
import org.jnario.lib.ExampleTableRow;

public class EnumParserSpecExamples extends ExampleTableRow {
  public EnumParserSpecExamples(final List<String> cellNames, final String input, final String name, final List<? extends Object> literals) {
    super(cellNames);
    this.input = input;
    this.name = name;
    this.literals = literals;
  }
  
  public String input;
  
  public String getInput() {
    return input;
  }
  
  public String name;
  
  public String getName() {
    return name;
  }
  
  public List<? extends Object> literals;
  
  public List<? extends Object> getLiterals() {
    return literals;
  }
  
  public List<String> getCells() {
    return java.util.Arrays.asList(toString(input) ,toString(name) ,toString(literals));
  }
}
