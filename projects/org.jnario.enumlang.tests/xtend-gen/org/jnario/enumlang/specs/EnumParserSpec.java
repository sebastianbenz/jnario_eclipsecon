package org.jnario.enumlang.specs;

import java.util.List;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hamcrest.StringDescription;
import org.jnario.enumlang.popup.actions.EnumParser;
import org.jnario.enumlang.popup.actions.MyEnum;
import org.jnario.enumlang.specs.EnumParserSpecExamples;
import org.jnario.lib.ExampleTable;
import org.jnario.lib.ExampleTableIterators;
import org.jnario.lib.JnarioCollectionLiterals;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.runner.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("EnumParser")
public class EnumParserSpec {
  @Subject
  public EnumParser subject;
  
  @Before
  public void _initEnumParserSpecExamples() {
    
    List<Object> _list = JnarioCollectionLiterals.<Object>list();
    List<String> _list_1 = JnarioCollectionLiterals.<String>list("RED");
    List<String> _list_2 = JnarioCollectionLiterals.<String>list("RED", "GREEN");
    List<String> _list_3 = JnarioCollectionLiterals.<String>list("RED", "GREEN");examples = ExampleTable.create("examples", 
      java.util.Arrays.asList("input", "name", "literals"), 
      new EnumParserSpecExamples(  java.util.Arrays.asList("\"Color\"", "\"Color\"", "list()"), "Color", "Color", _list),
      new EnumParserSpecExamples(  java.util.Arrays.asList("\"Color:RED\"", "\"Color\"", "list(\"RED\")"), "Color:RED", "Color", _list_1),
      new EnumParserSpecExamples(  java.util.Arrays.asList("\"Color:RED,GREEN\"", "\"Color\"", "list(\"RED\", \"GREEN\")"), "Color:RED,GREEN", "Color", _list_2),
      new EnumParserSpecExamples(  java.util.Arrays.asList("\"Color : RED , GREEN\"", "\"Color\"", "list(\"RED\", \"GREEN\")"), "Color : RED , GREEN", "Color", _list_3)
    );
  }
  
  protected ExampleTable<EnumParserSpecExamples> examples;
  
  @Test
  @Named("parses enums with the following format \\\'Name:Literal1,Literal2\\\'")
  @Order(0)
  public void _parsesEnumsWithTheFollowingFormatNameLiteral1Literal2() throws Exception {
    final Procedure1<EnumParserSpecExamples> _function = new Procedure1<EnumParserSpecExamples>() {
        public void apply(final EnumParserSpecExamples it) {
          final MyEnum enum_ = EnumParserSpec.this.subject.parse(it.input);
          String _name = enum_.getName();
          boolean _doubleArrow = Should.operator_doubleArrow(_name, it.name);
          Assert.assertTrue("\nExpected enum.name => name but"
           + "\n     enum.name is " + new StringDescription().appendValue(_name).toString()
           + "\n     enum is " + new StringDescription().appendValue(enum_).toString()
           + "\n     name is " + new StringDescription().appendValue(it.name).toString() + "\n", _doubleArrow);
          
          List<String> _literals = enum_.getLiterals();
          boolean _doubleArrow_1 = Should.operator_doubleArrow(_literals, it.literals);
          Assert.assertTrue("\nExpected enum.literals => literals but"
           + "\n     enum.literals is " + new StringDescription().appendValue(_literals).toString()
           + "\n     enum is " + new StringDescription().appendValue(enum_).toString()
           + "\n     literals is " + new StringDescription().appendValue(it.literals).toString() + "\n", _doubleArrow_1);
          
        }
      };
    ExampleTableIterators.<EnumParserSpecExamples>forEach(this.examples, _function);
  }
}
