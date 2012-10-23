package coffee;

import coffee.CoffeeDrinker;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CoffeeListParser {
  public List<CoffeeDrinker> parse(final String input) {
    List<CoffeeDrinker> _xblockexpression = null;
    {
      boolean _isEmpty = input.isEmpty();
      if (_isEmpty) {
        return CollectionLiterals.<CoffeeDrinker>emptyList();
      }
      final String[] lines = input.split("\n");
      final Function1<String,CoffeeDrinker> _function = new Function1<String,CoffeeDrinker>() {
          public CoffeeDrinker apply(final String it) {
            CoffeeDrinker _parseCoffeeDrinker = CoffeeListParser.this.parseCoffeeDrinker(it);
            return _parseCoffeeDrinker;
          }
        };
      List<CoffeeDrinker> _map = ListExtensions.<String, CoffeeDrinker>map(((List<String>)Conversions.doWrapArray(lines)), _function);
      _xblockexpression = (_map);
    }
    return _xblockexpression;
  }
  
  public CoffeeDrinker parseCoffeeDrinker(final String input) {
    CoffeeDrinker _xblockexpression = null;
    {
      final int firstPipeIndex = input.indexOf("|");
      String name = input;
      int count = 0;
      int _minus = (-1);
      boolean _greaterThan = (firstPipeIndex > _minus);
      if (_greaterThan) {
        String _substring = input.substring(0, firstPipeIndex);
        name = _substring;
        int _length = input.length();
        int _minus_1 = (_length - firstPipeIndex);
        count = _minus_1;
      }
      String _trim = name.trim();
      CoffeeDrinker _coffeeDrinker = new CoffeeDrinker(_trim, count);
      _xblockexpression = (_coffeeDrinker);
    }
    return _xblockexpression;
  }
}
