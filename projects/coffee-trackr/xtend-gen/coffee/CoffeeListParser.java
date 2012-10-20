package coffee;

import coffee.CoffeeDrinker;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CoffeeListParser {
  public List<CoffeeDrinker> parse(final String input) {
    String[] _split = input.split("\n");
    final Function1<String,CoffeeDrinker> _function = new Function1<String,CoffeeDrinker>() {
        public CoffeeDrinker apply(final String it) {
          CoffeeDrinker _createCoffeeDrinker = CoffeeListParser.this.createCoffeeDrinker(it);
          return _createCoffeeDrinker;
        }
      };
    List<CoffeeDrinker> _map = ListExtensions.<String, CoffeeDrinker>map(((List<String>)Conversions.doWrapArray(_split)), _function);
    return _map;
  }
  
  public CoffeeDrinker createCoffeeDrinker(final String input) {
    CoffeeDrinker _xblockexpression = null;
    {
      final int index = input.indexOf("|");
      String name = "";
      int count = 0;
      int _minus = (-1);
      boolean _equals = (index == _minus);
      if (_equals) {
        name = input;
      } else {
        String _substring = input.substring(0, index);
        name = _substring;
        int _minus_1 = (index - 1);
        String _substring_1 = input.substring(_minus_1);
        String _replaceAll = _substring_1.replaceAll("^\\|", "");
        int _length = _replaceAll.length();
        int _minus_2 = (_length - 1);
        count = _minus_2;
      }
      String _trim = name.trim();
      CoffeeDrinker _coffeeDrinker = new CoffeeDrinker(_trim, count);
      _xblockexpression = (_coffeeDrinker);
    }
    return _xblockexpression;
  }
}
