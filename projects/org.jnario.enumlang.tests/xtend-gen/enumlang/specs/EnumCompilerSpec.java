package enumlang.specs;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.hamcrest.StringDescription;
import org.jnario.enumlang.popup.actions.EnumCompiler;
import org.jnario.enumlang.popup.actions.MyEnum;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.runner.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("EnumCompiler")
public class EnumCompilerSpec {
  @Subject
  public EnumCompiler subject;
  
  @Test
  @Named("generates Java enum for empty enum")
  @Order(0)
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
  @Order(1)
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
