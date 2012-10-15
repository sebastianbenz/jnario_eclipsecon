package org.jnario.enumlang.popup.actions;

import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.jnario.enumlang.popup.actions.MyEnum;

@SuppressWarnings("all")
public class EnumParser {
  public MyEnum parse(final String content) {
    MyEnum _xblockexpression = null;
    {
      final String[] segments = content.split(":");
      String _get = ((List<String>)Conversions.doWrapArray(segments)).get(0);
      final String name = _get.trim();
      List<String> literals = CollectionLiterals.<String>emptyList();
      int _size = ((List<String>)Conversions.doWrapArray(segments)).size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        String _get_1 = ((List<String>)Conversions.doWrapArray(segments)).get(1);
        String[] _split = _get_1.split(",");
        final Function1<String,String> _function = new Function1<String,String>() {
            public String apply(final String it) {
              String _trim = it.trim();
              return _trim;
            }
          };
        List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
        literals = _map;
      }
      MyEnum _myEnum = new MyEnum(name, literals);
      _xblockexpression = (_myEnum);
    }
    return _xblockexpression;
  }
}
