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
      String[] _split = input.split("\n");
      final Function1<String,CoffeeDrinker> _function = new Function1<String,CoffeeDrinker>() {
          public CoffeeDrinker apply(final String it) {
            CoffeeDrinker _createCoffeeDrinker = CoffeeListParser.this.createCoffeeDrinker(it);
            return _createCoffeeDrinker;
          }
        };
      List<CoffeeDrinker> _map = ListExtensions.<String, CoffeeDrinker>map(((List<String>)Conversions.doWrapArray(_split)), _function);
      _xblockexpression = (_map);
    }
    return _xblockexpression;
  }
  
  public CoffeeDrinker createCoffeeDrinker(final String string) {
    final int i = string.indexOf("|");
    String name = string;
    int coffeeCount = 0;
    int _minus = (-1);
    boolean _greaterThan = (i > _minus);
    if (_greaterThan) {
      String _substring = name.substring(0, i);
      name = _substring;
      int _length = string.length();
      int _length_1 = name.length();
      int _minus_1 = (_length - _length_1);
      coffeeCount = _minus_1;
    }
    String _trim = name.trim();
    CoffeeDrinker _coffeeDrinker = new CoffeeDrinker(_trim, coffeeCount);
    return _coffeeDrinker;
  }
}
