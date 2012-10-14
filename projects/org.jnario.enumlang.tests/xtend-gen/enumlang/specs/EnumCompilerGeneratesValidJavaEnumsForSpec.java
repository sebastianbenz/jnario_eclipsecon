package enumlang.specs;

import enumlang.specs.EnumCompilerSpec;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("Generates valid Java enums for:")
public class EnumCompilerGeneratesValidJavaEnumsForSpec extends EnumCompilerSpec {
  @Test
  @Named("empty enums")
  @Order(0)
  public void _emptyEnums() throws Exception {
    CharSequence _compile = this.compile("EmptyEnum:");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package enums;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum EmptyEnum {");
    _builder.newLine();
    _builder.append("}");
    this.is(_compile, _builder);
  }
  
  @Test
  @Named("enums with single value literal")
  @Order(1)
  public void _enumsWithSingleValueLiteral() throws Exception {
    CharSequence _compile = this.compile("SingleLiteral: VALUE");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package enums;");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("public enum SingleLiteral {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("VALUE");
    _builder.newLine();
    _builder.append("}");
    this.is(_compile, _builder);
  }
  
  @Test
  @Named("enums with multiple values")
  @Order(2)
  public void _enumsWithMultipleValues() throws Exception {
    CharSequence _compile = this.compile("MultipleLiterals: VALUE1,VALUE2");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package enums;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum MultipleLiterals {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("VALUE1, VALUE2");
    _builder.newLine();
    _builder.append("}");
    this.is(_compile, _builder);
  }
}
