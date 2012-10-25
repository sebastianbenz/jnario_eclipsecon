package specs;

import coffee.CoffeeDrinker;
import coffee.CoffeeListParser;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hamcrest.StringDescription;
import org.jnario.lib.ExampleTable;
import org.jnario.lib.ExampleTableIterators;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.runner.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import specs.CoffeeListParserSpecExamples;

/**
 * This is a simple parser for coffee lists.
 */
@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("CoffeeListParser")
public class CoffeeListParserSpec {
  @Subject
  public CoffeeListParser subject;
  
  @Test
  @Named("Empty string has no coffee drinkers")
  @Order(0)
  public void _emptyStringHasNoCoffeeDrinkers() throws Exception {
    List<CoffeeDrinker> _parse = this.parse("");
    List<?> _emptyList = CollectionLiterals.emptyList();
    boolean _doubleArrow = Should.operator_doubleArrow(_parse, _emptyList);
    Assert.assertTrue("\nExpected \"\".parse => emptyList but"
     + "\n     \"\".parse is " + new StringDescription().appendValue(_parse).toString()
     + "\n     emptyList is " + new StringDescription().appendValue(_emptyList).toString() + "\n", _doubleArrow);
    
  }
  
  @Before
  public void _initCoffeeListParserSpecExamples() {
    examples = ExampleTable.create("examples", 
      java.util.Arrays.asList("input", "expectedName", "expectedCoffeeCount"), 
      new CoffeeListParserSpecExamples(  java.util.Arrays.asList("\"Sebastian\"", "\"Sebastian\"", "0"), "Sebastian", "Sebastian", 0),
      new CoffeeListParserSpecExamples(  java.util.Arrays.asList("\"Sebastian|\"", "\"Sebastian\"", "1"), "Sebastian|", "Sebastian", 1),
      new CoffeeListParserSpecExamples(  java.util.Arrays.asList("\"Sebastian |\"", "\"Sebastian\"", "1"), "Sebastian |", "Sebastian", 1),
      new CoffeeListParserSpecExamples(  java.util.Arrays.asList("\"Sebastian |||\"", "\"Sebastian\"", "3"), "Sebastian |||", "Sebastian", 3)
    );
  }
  
  protected ExampleTable<CoffeeListParserSpecExamples> examples;
  
  @Test
  @Named("Coffee per drinker has the format NAME |*")
  @Order(1)
  public void _coffeePerDrinkerHasTheFormatNAME() throws Exception {
    final Procedure1<CoffeeListParserSpecExamples> _function = new Procedure1<CoffeeListParserSpecExamples>() {
        public void apply(final CoffeeListParserSpecExamples it) {
          List<CoffeeDrinker> _parse = CoffeeListParserSpec.this.parse(it.input);
          final CoffeeDrinker coffeeDrinker = JnarioIterableExtensions.<CoffeeDrinker>first(_parse);
          String _name = coffeeDrinker.getName();
          boolean _doubleArrow = Should.operator_doubleArrow(_name, it.expectedName);
          Assert.assertTrue("\nExpected coffeeDrinker.name \t\t\t=> expectedName but"
           + "\n     coffeeDrinker.name is " + new StringDescription().appendValue(_name).toString()
           + "\n     coffeeDrinker is " + new StringDescription().appendValue(coffeeDrinker).toString()
           + "\n     expectedName is " + new StringDescription().appendValue(it.expectedName).toString() + "\n", _doubleArrow);
          
          int _coffeeCount = coffeeDrinker.getCoffeeCount();
          boolean _doubleArrow_1 = Should.operator_doubleArrow(Integer.valueOf(_coffeeCount), Integer.valueOf(it.expectedCoffeeCount));
          Assert.assertTrue("\nExpected coffeeDrinker.coffeeCount \t=> expectedCoffeeCount but"
           + "\n     coffeeDrinker.coffeeCount is " + new StringDescription().appendValue(Integer.valueOf(_coffeeCount)).toString()
           + "\n     coffeeDrinker is " + new StringDescription().appendValue(coffeeDrinker).toString()
           + "\n     expectedCoffeeCount is " + new StringDescription().appendValue(Integer.valueOf(it.expectedCoffeeCount)).toString() + "\n", _doubleArrow_1);
          
        }
      };
    ExampleTableIterators.<CoffeeListParserSpecExamples>forEach(this.examples, _function);
  }
  
  @Test
  @Named("Multiple coffee drinkers are separated by newline characters")
  @Order(2)
  public void _multipleCoffeeDrinkersAreSeparatedByNewlineCharacters() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Sebastian \t||");
    _builder.newLine();
    _builder.append("Birgit \t\t|||");
    _builder.newLine();
    List<CoffeeDrinker> _parse = this.parse(_builder);
    int _size = _parse.size();
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_size), Integer.valueOf(2));
    Assert.assertTrue("\nExpected \'\'\'\n\t\t\tSebastian \t||\n\t\t\tBirgit \t\t|||\n\t\t\'\'\'.parse.size => 2 but"
     + "\n     \'\'\'\n\t\t\tSebastian \t||\n\t\t\tBirgit \t\t|||\n\t\t\'\'\'.parse.size is " + new StringDescription().appendValue(Integer.valueOf(_size)).toString()
     + "\n     \'\'\'\n\t\t\tSebastian \t||\n\t\t\tBirgit \t\t|||\n\t\t\'\'\'.parse is " + new StringDescription().appendValue(_parse).toString()
     + "\n     \'\'\'\n\t\t\tSebastian \t||\n\t\t\tBirgit \t\t|||\n\t\t\'\'\' is " + new StringDescription().appendValue(_builder).toString() + "\n", _doubleArrow);
    
  }
  
  public List<CoffeeDrinker> parse(final CharSequence s) {
    String _string = s.toString();
    List<CoffeeDrinker> _parse = this.subject.parse(_string);
    return _parse;
  }
}
