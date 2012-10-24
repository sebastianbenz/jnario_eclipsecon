package coffee;

import coffee.CoffeeDrinker;
import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class CoffeeTracker {
  private final List<CoffeeDrinker> _coffeeDrinkers;
  
  public List<CoffeeDrinker> getCoffeeDrinkers() {
    return this._coffeeDrinkers;
  }
  
  public int overallConsumption() {
    Integer _xblockexpression = null;
    {
      List<CoffeeDrinker> _coffeeDrinkers = this.getCoffeeDrinkers();
      boolean _isEmpty = _coffeeDrinkers.isEmpty();
      if (_isEmpty) {
        return 0;
      }
      List<CoffeeDrinker> _coffeeDrinkers_1 = this.getCoffeeDrinkers();
      final Function1<CoffeeDrinker,Integer> _function = new Function1<CoffeeDrinker,Integer>() {
          public Integer apply(final CoffeeDrinker it) {
            int _coffeeCount = it.getCoffeeCount();
            return Integer.valueOf(_coffeeCount);
          }
        };
      List<Integer> _map = ListExtensions.<CoffeeDrinker, Integer>map(_coffeeDrinkers_1, _function);
      final Function2<Integer,Integer,Integer> _function_1 = new Function2<Integer,Integer,Integer>() {
          public Integer apply(final Integer a, final Integer b) {
            int _plus = ((a).intValue() + (b).intValue());
            return Integer.valueOf(_plus);
          }
        };
      Integer _reduce = IterableExtensions.<Integer>reduce(_map, _function_1);
      _xblockexpression = (_reduce);
    }
    return (_xblockexpression).intValue();
  }
  
  public int consumptionOf(final String name) {
    int _minus = (-1);
    return _minus;
  }
  
  public CoffeeTracker(final List<CoffeeDrinker> coffeeDrinkers) {
    super();
    this._coffeeDrinkers = coffeeDrinkers;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_coffeeDrinkers== null) ? 0 : _coffeeDrinkers.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CoffeeTracker other = (CoffeeTracker) obj;
    if (_coffeeDrinkers == null) {
      if (other._coffeeDrinkers != null)
        return false;
    } else if (!_coffeeDrinkers.equals(other._coffeeDrinkers))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
