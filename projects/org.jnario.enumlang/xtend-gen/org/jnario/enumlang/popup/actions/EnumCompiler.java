package org.jnario.enumlang.popup.actions;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EnumCompiler {
  public CharSequence compile(final String input) {
    CharSequence _xblockexpression = null;
    {
      boolean _or = false;
      boolean _equals = Objects.equal(input, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _isEmpty = input.isEmpty();
        _or = (_equals || _isEmpty);
      }
      if (_or) {
        IllegalArgumentException _illegalArgumentException = new IllegalArgumentException();
        throw _illegalArgumentException;
      }
      final String[] segments = input.split(":");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package enums;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public enum ");
      String _name = this.name(((List<String>)Conversions.doWrapArray(segments)));
      _builder.append(_name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _valueString = this.valueString(((List<String>)Conversions.doWrapArray(segments)));
      _builder.append(_valueString, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public String name(final List<String> segments) {
    String _head = IterableExtensions.<String>head(segments);
    String _trim = _head.trim();
    String _checkForWhitespaces = this.checkForWhitespaces(_trim);
    return _checkForWhitespaces;
  }
  
  public String checkForWhitespaces(final String name) {
    String _xblockexpression = null;
    {
      final String whitespace = " \t\n\r";
      char[] _charArray = whitespace.toCharArray();
      final Procedure1<Character> _function = new Procedure1<Character>() {
          public void apply(final Character it) {
            String _string = it.toString();
            boolean _contains = name.contains(_string);
            if (_contains) {
              IllegalArgumentException _illegalArgumentException = new IllegalArgumentException();
              throw _illegalArgumentException;
            }
          }
        };
      IterableExtensions.<Character>forEach(((Iterable<Character>)Conversions.doWrapArray(_charArray)), _function);
      _xblockexpression = (name);
    }
    return _xblockexpression;
  }
  
  public String valueString(final List<String> segments) {
    String _xblockexpression = null;
    {
      String valueString = "";
      int _size = segments.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        String _last = IterableExtensions.<String>last(segments);
        String[] values = _last.split(",");
        final String[] _converted_values = (String[])values;
        final Function1<String,String> _function = new Function1<String,String>() {
            public String apply(final String it) {
              String _trim = it.trim();
              return _trim;
            }
          };
        List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_converted_values)), _function);
        String _join = IterableExtensions.join(_map, ", ");
        valueString = _join;
      }
      _xblockexpression = (valueString);
    }
    return _xblockexpression;
  }
}
