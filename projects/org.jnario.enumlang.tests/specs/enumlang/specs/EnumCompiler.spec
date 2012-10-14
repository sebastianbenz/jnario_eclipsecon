package enumlang.specs

import org.jnario.enumlang.popup.actions.EnumCompiler
import org.junit.Assert

describe EnumCompiler {
  
  context "Generates valid Java enums for:"{
    fact "empty enums"{
      compile("EmptyEnum:").is('''
        package enums;

        public enum EmptyEnum {
        }'''
      )
    }
    fact "enums with single value literal"{
      compile("SingleLiteral: VALUE").is('''
        package enums;
         
        public enum SingleLiteral {
          VALUE
        }'''
      )
    }
    fact "enums with multiple values"{
      compile("MultipleLiterals: VALUE1,VALUE2").is('''
        package enums;

        public enum MultipleLiterals {
          VALUE1, VALUE2
        }'''
      )        
    }
  }
  
  context "Invalid inputs"{
    fact compile(null) should throw IllegalArgumentException
    fact compile("") should throw IllegalArgumentException
    fact compile("Colors MISSING COLON") should throw IllegalArgumentException
  }
    
  def CharSequence compile(String s){
    subject.compile(s)
  }
  
  def operator_doubleArrow(Object actual, Object expected){
  	true
  }
  
  def is(Object actual, Object expected){
    Assert::assertEquals(expected.toString, actual.toString)
    true
  }

} 