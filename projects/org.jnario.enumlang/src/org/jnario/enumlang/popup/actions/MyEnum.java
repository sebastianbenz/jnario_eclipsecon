package org.jnario.enumlang.popup.actions;

import java.util.List;

public class MyEnum {
	
	private final String name;
	private final List<String> literals;
	
	public MyEnum(String name, List<String> literals) {
		this.name = name;
		this.literals = literals;
	}
	
	public List<String> getLiterals() {
		return literals;
	}
	
	public String getName() {
		return name;
	}
}
