package org.jnario.enumlang.popup.actions;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jnario.enumlang.popup.actions.MyEnum;

@SuppressWarnings("all")
public class EnumCompiler {
  public CharSequence compile(final MyEnum input) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package enums;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum ");
    String _name = input.getName();
    _builder.append(_name, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    List<String> _literals = input.getLiterals();
    String _join = IterableExtensions.join(_literals, ", ");
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
