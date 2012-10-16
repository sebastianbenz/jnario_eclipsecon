package org.jnario.enumlang.specs

import org.jnario.enumlang.popup.actions.MyEnum
import org.jnario.enumlang.popup.actions.EnumCompiler

describe EnumCompiler{
	
	def {
		| input   | expect |
		| "asdfs" | typeof(RuntimeException)|
	}
	
	fact examples.forEach[
		try{
			input.toBool 
		}catch(Exception e){
			e => expect
		}
	]
	
	fact "generates Java enum for empty enum"{
		compile("Colors").toString => '''
			package enums;
			
			public enum Colors{
			}
		'''.toString
	}
	
	fact "generates Java enum for multi literal enum"{
		compile("Colors", "RED", "BLUE").toString => '''
			package enums;
			
			public enum Colors{
				RED, BLUE
			}
		'''.toString
	}

	def compile(String name, String... inputs){
		val input = new MyEnum("Colors", inputs)
		subject.compile(input)
	}
}