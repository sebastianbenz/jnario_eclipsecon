package org.jnario.enumlang.specs;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hamcrest.StringDescription;
import org.jnario.enumlang.popup.actions.EnumCompiler;
import org.jnario.enumlang.popup.actions.MyEnum;
import org.jnario.enumlang.specs.EnumCompilerSpecExamples;
import org.jnario.lib.ExampleTable;
import org.jnario.lib.ExampleTableIterators;
import org.jnario.lib.Should;
import org.jnario.lib.StringConversions;
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
@Named("EnumCompiler")
public class EnumCompilerSpec {
  @Subject
  public EnumCompiler subject;
  
  @Before
  public void _initEnumCompilerSpecExamples() {
    examples = ExampleTable.create("examples", 
      java.util.Arrays.asList("input", "expect"), 
      new EnumCompilerSpecExamples(  java.util.Arrays.asList("\"asdfs\"", "typeof(RuntimeException)"), "asdfs", RuntimeException.class)
    );
  }
  
  protected ExampleTable<EnumCompilerSpecExamples> examples;
  
  @Test
  @Named("examples.forEach[ try{ input.toBool }catch[Exception e]{ e => expect } ]")
  @Order(0)
  public void _examplesForEachTryInputToBoolCatchExceptionEEExpect() throws Exception {
    final Procedure1<EnumCompilerSpecExamples> _function = new Procedure1<EnumCompilerSpecExamples>() {
        public void apply(final EnumCompilerSpecExamples it) {
          try {
            StringConversions.toBool(it.input);
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              boolean _doubleArrow = Should.operator_doubleArrow(e, it.expect);
              Assert.assertTrue("\nExpected e => expect but"
               + "\n     e is " + new StringDescription().appendValue(e).toString()
               + "\n     expect is " + new StringDescription().appendValue(it.expect).toString() + "\n", _doubleArrow);
              
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
    ExampleTableIterators.<EnumCompilerSpecExamples>forEach(this.examples, _function);
  }
  
  @Test
  @Named("generates Java enum for empty enum")
  @Order(1)
  public void _generatesJavaEnumForEmptyEnum() throws Exception {
    CharSequence _compile = this.compile("Colors");
    String _string = _compile.toString();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package enums;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum Colors{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _string_1 = _builder.toString();
    boolean _doubleArrow = Should.operator_doubleArrow(_string, _string_1);
    Assert.assertTrue("\nExpected compile(\"Colors\").toString => \'\'\'\n\t\t\tpackage enums;\n\t\t\t\n\t\t\tpublic enum Colors{\n\t\t\t}\n\t\t\'\'\'.toString but"
     + "\n     compile(\"Colors\").toString is " + new StringDescription().appendValue(_string).toString()
     + "\n     compile(\"Colors\") is " + new StringDescription().appendValue(_compile).toString()
     + "\n     \'\'\'\n\t\t\tpackage enums;\n\t\t\t\n\t\t\tpublic enum Colors{\n\t\t\t}\n\t\t\'\'\'.toString is " + new StringDescription().appendValue(_string_1).toString()
     + "\n     \'\'\'\n\t\t\tpackage enums;\n\t\t\t\n\t\t\tpublic enum Colors{\n\t\t\t}\n\t\t\'\'\' is " + new StringDescription().appendValue(_builder).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("generates Java enum for multi literal enum")
  @Order(2)
  public void _generatesJavaEnumForMultiLiteralEnum() throws Exception {
    CharSequence _compile = this.compile("Colors", "RED", "BLUE");
    String _string = _compile.toString();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package enums;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum Colors{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("RED, BLUE");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _string_1 = _builder.toString();
    boolean _doubleArrow = Should.operator_doubleArrow(_string, _string_1);
    Assert.assertTrue("\nExpected compile(\"Colors\", \"RED\", \"BLUE\").toString => \'\'\'\n\t\t\tpackage enums;\n\t\t\t\n\t\t\tpublic enum Colors{\n\t\t\t\tRED, BLUE\n\t\t\t}\n\t\t\'\'\'.toString but"
     + "\n     compile(\"Colors\", \"RED\", \"BLUE\").toString is " + new StringDescription().appendValue(_string).toString()
     + "\n     compile(\"Colors\", \"RED\", \"BLUE\") is " + new StringDescription().appendValue(_compile).toString()
     + "\n     \'\'\'\n\t\t\tpackage enums;\n\t\t\t\n\t\t\tpublic enum Colors{\n\t\t\t\tRED, BLUE\n\t\t\t}\n\t\t\'\'\'.toString is " + new StringDescription().appendValue(_string_1).toString()
     + "\n     \'\'\'\n\t\t\tpackage enums;\n\t\t\t\n\t\t\tpublic enum Colors{\n\t\t\t\tRED, BLUE\n\t\t\t}\n\t\t\'\'\' is " + new StringDescription().appendValue(_builder).toString() + "\n", _doubleArrow);
    
  }
  
  public CharSequence compile(final String name, final String... inputs) {
    CharSequence _xblockexpression = null;
    {
      MyEnum _myEnum = new MyEnum("Colors", ((List<String>)Conversions.doWrapArray(inputs)));
      final MyEnum input = _myEnum;
      CharSequence _compile = this.subject.compile(input);
      _xblockexpression = (_compile);
    }
    return _xblockexpression;
  }
}
