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
import org.jnario.lib.JnarioCollectionLiterals;
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
import specs.CoffeeListParserSpecCoffeeDrinkers;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("CoffeeListParser")
public class CoffeeListParserSpec {
  @Subject
  public CoffeeListParser subject;
  
  final CoffeeListParser parser = new Function0<CoffeeListParser>() {
    public CoffeeListParser apply() {
      CoffeeListParser _coffeeListParser = new CoffeeListParser();
      return _coffeeListParser;
    }
  }.apply();
  
  @Before
  public void _initCoffeeListParserSpecCoffeeDrinkers() {
    coffeeDrinkers = ExampleTable.create("coffeeDrinkers", 
      java.util.Arrays.asList("coffeList", "expectedName", "expectedCoffeeCount"), 
      new CoffeeListParserSpecCoffeeDrinkers(  java.util.Arrays.asList("\"Sebastian\"", "\"Sebastian\"", "0"), "Sebastian", "Sebastian", 0),
      new CoffeeListParserSpecCoffeeDrinkers(  java.util.Arrays.asList("\"Sebastian \"", "\"Sebastian\"", "0"), "Sebastian ", "Sebastian", 0),
      new CoffeeListParserSpecCoffeeDrinkers(  java.util.Arrays.asList("\"Sebastian |\"", "\"Sebastian\"", "1"), "Sebastian |", "Sebastian", 1),
      new CoffeeListParserSpecCoffeeDrinkers(  java.util.Arrays.asList("\"Sebastian ||\"", "\"Sebastian\"", "2"), "Sebastian ||", "Sebastian", 2),
      new CoffeeListParserSpecCoffeeDrinkers(  java.util.Arrays.asList("\"Sebastian |||\"", "\"Sebastian\"", "3"), "Sebastian |||", "Sebastian", 3)
    );
  }
  
  protected ExampleTable<CoffeeListParserSpecCoffeeDrinkers> coffeeDrinkers;
  
  @Test
  @Named("coffee consumption per person has the format Name |||")
  @Order(0)
  public void _coffeeConsumptionPerPersonHasTheFormatName() throws Exception {
    final Procedure1<CoffeeListParserSpecCoffeeDrinkers> _function = new Procedure1<CoffeeListParserSpecCoffeeDrinkers>() {
        public void apply(final CoffeeListParserSpecCoffeeDrinkers it) {
          List<CoffeeDrinker> _parse = CoffeeListParserSpec.this.parse(it.coffeList);
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
    ExampleTableIterators.<CoffeeListParserSpecCoffeeDrinkers>forEach(this.coffeeDrinkers, _function);
  }
  
  @Test
  @Named("coffee drinkers are separated by newline")
  @Order(1)
  public void _coffeeDrinkersAreSeparatedByNewline() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Sebastian ||");
    _builder.newLine();
    _builder.append("Birgit |");
    _builder.newLine();
    List<CoffeeDrinker> _parse = this.parse(_builder);
    CoffeeDrinker _coffeeDrinker = new CoffeeDrinker("Sebastian", 2);
    CoffeeDrinker _coffeeDrinker_1 = new CoffeeDrinker("Birgit", 1);
    List<CoffeeDrinker> _list = JnarioCollectionLiterals.<CoffeeDrinker>list(_coffeeDrinker, _coffeeDrinker_1);
    boolean _doubleArrow = Should.operator_doubleArrow(_parse, _list);
    Assert.assertTrue("\nExpected \'\'\'\n\t\t\tSebastian ||\n\t\t\tBirgit |\n\t\t\'\'\'.parse => list(\n\t\t\tnew CoffeeDrinker(\"Sebastian\", 2),\n\t\t\tnew CoffeeDrinker(\"Birgit\", 1)\n\t\t) but"
     + "\n     \'\'\'\n\t\t\tSebastian ||\n\t\t\tBirgit |\n\t\t\'\'\'.parse is " + new StringDescription().appendValue(_parse).toString()
     + "\n     \'\'\'\n\t\t\tSebastian ||\n\t\t\tBirgit |\n\t\t\'\'\' is " + new StringDescription().appendValue(_builder).toString()
     + "\n     list(\n\t\t\tnew CoffeeDrinker(\"Sebastian\", 2),\n\t\t\tnew CoffeeDrinker(\"Birgit\", 1)\n\t\t) is " + new StringDescription().appendValue(_list).toString()
     + "\n     new CoffeeDrinker(\"Sebastian\", 2) is " + new StringDescription().appendValue(_coffeeDrinker).toString()
     + "\n     new CoffeeDrinker(\"Birgit\", 1) is " + new StringDescription().appendValue(_coffeeDrinker_1).toString() + "\n", _doubleArrow);
    
  }
  
  public List<CoffeeDrinker> parse(final CharSequence string) {
    String _string = string.toString();
    List<CoffeeDrinker> _parse = this.subject.parse(_string);
    return _parse;
  }
}
