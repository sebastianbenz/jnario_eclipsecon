package org.jnario.enumlang.popup.actions

import org.jnario.enumlang.popup.actions.MyEnum

class EnumCompiler { 
	
	def compile(MyEnum input)'''
		package enums;
		
		public enum «input.name»{
			«input.literals.join(", ")»
		}
	'''
} 

