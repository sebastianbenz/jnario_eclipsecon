package enumlang;

import enumlang.EnumCompilerSpec;
import org.hamcrest.StringDescription;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("invalid inputs")
public class EnumCompilerInvalidInputsSpec extends EnumCompilerSpec {
  @Test
  @Named("compile[null] throws IllegalArgumentException")
  @Order(99)
  public void _compileNullThrowsIllegalArgumentException() throws Exception {
    try{
      this.compile(null);
      Assert.fail("Expected " + IllegalArgumentException.class.getName() + " in \n     compile(null)\n with:"
       + "\n     compile(null) is " + new StringDescription().appendValue(this.compile(null)).toString());
    }catch(IllegalArgumentException e){
      // expected
    }
  }
  
  @Test
  @Named("compile[\\\"\\\"] throws IllegalArgumentException")
  @Order(99)
  public void _compileThrowsIllegalArgumentException() throws Exception {
    try{
      this.compile("");
      Assert.fail("Expected " + IllegalArgumentException.class.getName() + " in \n     compile(\"\")\n with:"
       + "\n     compile(\"\") is " + new StringDescription().appendValue(this.compile("")).toString());
    }catch(IllegalArgumentException e){
      // expected
    }
  }
  
  @Test
  @Named("compile[\\\"Colors MISSING COLON\\\"] throws IllegalArgumentException")
  @Order(99)
  public void _compileColorsMISSINGCOLONThrowsIllegalArgumentException() throws Exception {
    try{
      this.compile("Colors MISSING COLON");
      Assert.fail("Expected " + IllegalArgumentException.class.getName() + " in \n     compile(\"Colors MISSING COLON\")\n with:"
       + "\n     compile(\"Colors MISSING COLON\") is " + new StringDescription().appendValue(this.compile("Colors MISSING COLON")).toString());
    }catch(IllegalArgumentException e){
      // expected
    }
  }
}
