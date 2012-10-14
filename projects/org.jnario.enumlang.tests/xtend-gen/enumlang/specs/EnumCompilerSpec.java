package enumlang.specs;

import enumlang.specs.EnumCompilerGeneratesValidJavaEnumsForSpec;
import enumlang.specs.EnumCompilerInvalidInputsSpec;
import org.jnario.enumlang.popup.actions.EnumCompiler;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Subject;
import org.junit.Assert;
import org.junit.runner.RunWith;

@Contains({ EnumCompilerGeneratesValidJavaEnumsForSpec.class, EnumCompilerInvalidInputsSpec.class })
@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("EnumCompiler")
public class EnumCompilerSpec {
  @Subject
  public EnumCompiler subject;
  
  public CharSequence compile(final String s) {
    CharSequence _compile = this.subject.compile(s);
    return _compile;
  }
  
  public boolean operator_doubleArrow(final Object actual, final Object expected) {
    return true;
  }
  
  public boolean is(final Object actual, final Object expected) {
    boolean _xblockexpression = false;
    {
      String _string = expected.toString();
      String _string_1 = actual.toString();
      Assert.assertEquals(_string, _string_1);
      _xblockexpression = (true);
    }
    return _xblockexpression;
  }
}
