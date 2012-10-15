package org.jnario.enumlang.popup.actions

import org.jnario.enumlang.popup.actions.MyEnum

class EnumParser {
	
	def MyEnum parse(String content){
		val segments = content.split(":")
		val name = segments.get(0).trim
		var literals = <String>emptyList
		if(segments.size > 1){
			literals = segments.get(1).split(",").map[trim]
		}
		new MyEnum(name, literals)
	}
	
} 

class EnumCompiler { 
	
	def compile(MyEnum input)'''
		package enums;
		
		public enum «input.name»{
			«input.literals.join(", ")»
		}
	'''
} 

