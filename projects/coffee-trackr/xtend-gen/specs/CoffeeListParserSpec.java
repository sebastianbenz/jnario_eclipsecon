package specs;

import coffee.CoffeeDrinker;
import coffee.CoffeeListParser;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hamcrest.StringDescription;
import org.jnario.lib.ExampleTable;
import org.jnario.lib.ExampleTableIterators;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import specs.CoffeeListParserSpecExamples;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("CoffeeListParser")
public class CoffeeListParserSpec {
  final CoffeeListParser parser = new Function0<CoffeeListParser>() {
    public CoffeeListParser apply() {
      CoffeeListParser _coffeeListParser = new CoffeeListParser();
      return _coffeeListParser;
    }
  }.apply();
  
  @Test
  @Named("empty list has not coffeedrinkers")
  @Order(0)
  public void _emptyListHasNotCoffeedrinkers() throws Exception {
    final List<CoffeeDrinker> coffeeDrinkers = this.parser.parse("");
    boolean _isEmpty = coffeeDrinkers.isEmpty();
    Assert.assertTrue("\nExpected coffeeDrinkers.empty but"
     + "\n     coffeeDrinkers is " + new StringDescription().appendValue(coffeeDrinkers).toString() + "\n", _isEmpty);
    
  }
  
  @Before
  public void _initCoffeeListParserSpecExamples() {
    examples = ExampleTable.create("examples", 
      java.util.Arrays.asList("input", "name", "count"), 
      new CoffeeListParserSpecExamples(  java.util.Arrays.asList("\"Sebastian\"", "\"Sebastian\"", "0"), "Sebastian", "Sebastian", 0),
      new CoffeeListParserSpecExamples(  java.util.Arrays.asList("\"Sebastian|\"", "\"Sebastian\"", "1"), "Sebastian|", "Sebastian", 1),
      new CoffeeListParserSpecExamples(  java.util.Arrays.asList("\"Sebastian||\"", "\"Sebastian\"", "2"), "Sebastian||", "Sebastian", 2),
      new CoffeeListParserSpecExamples(  java.util.Arrays.asList("\"Sebastian ||\"", "\"Sebastian\"", "2"), "Sebastian ||", "Sebastian", 2)
    );
  }
  
  protected ExampleTable<CoffeeListParserSpecExamples> examples;
  
  @Test
  @Named("coffee drinking count has the format NAME |*")
  @Order(1)
  public void _coffeeDrinkingCountHasTheFormatNAME() throws Exception {
    final Procedure1<CoffeeListParserSpecExamples> _function = new Procedure1<CoffeeListParserSpecExamples>() {
        public void apply(final CoffeeListParserSpecExamples it) {
          final List<CoffeeDrinker> coffeeDrinkers = CoffeeListParserSpec.this.parser.parse(it.input);
          final CoffeeDrinker firstDrinker = JnarioIterableExtensions.<CoffeeDrinker>first(coffeeDrinkers);
          String _name = firstDrinker.getName();
          boolean _doubleArrow = Should.operator_doubleArrow(_name, it.name);
          Assert.assertTrue("\nExpected firstDrinker.name \t\t\t=> name but"
           + "\n     firstDrinker.name is " + new StringDescription().appendValue(_name).toString()
           + "\n     firstDrinker is " + new StringDescription().appendValue(firstDrinker).toString()
           + "\n     name is " + new StringDescription().appendValue(it.name).toString() + "\n", _doubleArrow);
          
          int _coffeeCount = firstDrinker.getCoffeeCount();
          boolean _doubleArrow_1 = Should.operator_doubleArrow(Integer.valueOf(_coffeeCount), Integer.valueOf(it.count));
          Assert.assertTrue("\nExpected firstDrinker.coffeeCount \t=> count but"
           + "\n     firstDrinker.coffeeCount is " + new StringDescription().appendValue(Integer.valueOf(_coffeeCount)).toString()
           + "\n     firstDrinker is " + new StringDescription().appendValue(firstDrinker).toString()
           + "\n     count is " + new StringDescription().appendValue(Integer.valueOf(it.count)).toString() + "\n", _doubleArrow_1);
          
        }
      };
    ExampleTableIterators.<CoffeeListParserSpecExamples>forEach(this.examples, _function);
  }
  
  @Test
  @Named("multiple coffeedrinkers are separated by newline")
  @Order(2)
  public void _multipleCoffeedrinkersAreSeparatedByNewline() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Sebastian \t|||");
    _builder.newLine();
    _builder.append("Birgit \t\t||");
    _builder.newLine();
    String _string = _builder.toString();
    final List<CoffeeDrinker> coffeeDrinkers = this.parser.parse(_string);
    int _size = coffeeDrinkers.size();
    boolean _doubleArrow = Should.operator_doubleArrow(Integer.valueOf(_size), Integer.valueOf(2));
    Assert.assertTrue("\nExpected coffeeDrinkers.size => 2 but"
     + "\n     coffeeDrinkers.size is " + new StringDescription().appendValue(Integer.valueOf(_size)).toString()
     + "\n     coffeeDrinkers is " + new StringDescription().appendValue(coffeeDrinkers).toString() + "\n", _doubleArrow);
    
  }
}
