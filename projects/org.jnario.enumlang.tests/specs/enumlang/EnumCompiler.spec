package enumlang

import org.jnario.enumlang.popup.actions.EnumCompiler
import org.junit.Assert

describe EnumCompiler {
	
	context "generates valid Java enums for..."{
		fact "for empty enums"{
		compile("EmptyEnum:").is('''
			package enums;

			public enum EmptyEnum {
			}''')
 		
 		compile("AnotherEmptyEnum:").is('''
			package enums;

			public enum AnotherEmptyEnum {
			}''')
	 	}
	 	fact "enums with single value literal"{
	 		compile("SingleLiteral: VALUE").is('''
				package enums;
				
				public enum SingleLiteral {
					VALUE
				}''')
	 	}
	 	fact "enums with multiple values"{
	 		compile("MultipleLiterals: VALUE1,VALUE2").is('''
				package enums;

				public enum MultipleLiterals {
					VALUE1, VALUE2
				}''') 	 		
		}
	}
	
	context "invalid inputs"{
		fact compile(null) throws IllegalArgumentException
		fact compile("") throws IllegalArgumentException
		fact compile("Colors MISSING COLON") throws IllegalArgumentException
	}
		
	def CharSequence compile(String s){
		subject.compile(s)
	}
	
	def is(Object actual, Object expected){
		Assert::assertEquals(expected.toString, actual.toString)
		true
	}

} 