package org.jnario.enumlang.popup.actions

import java.util.List

class EnumCompiler {
	
	def compile(String input){
		if(input == null || input.empty){
			throw new IllegalArgumentException
		}
		val segments = input.split(":")
		
		'''
		package enums;

		public enum «segments.name» {
			«segments.valueString»
		}'''
	}
	
	def name(List<String> segments){
		segments.head.trim.checkForWhitespaces
	}
	
	def checkForWhitespaces(String name) {
		val whitespace = " \t\n\r"
		whitespace.toCharArray.forEach[
			if(name.contains(it.toString)){
				throw new IllegalArgumentException
			}			
		]
		name
	}
	
	def valueString(List<String> segments){
		var valueString = ""
		if(segments.size > 1){
			var values = segments.last.split(",")
			valueString = values.map[trim].join(", ")
		}
		valueString
	} 
	
}