package coffee;

import coffee.CoffeeDrinker;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class CoffeeTracker {
  private final List<CoffeeDrinker> _coffeeDrinkers;
  
  public List<CoffeeDrinker> getCoffeeDrinkers() {
    return this._coffeeDrinkers;
  }
  
  public int overallConsumption() {
    int _minus = (-1);
    return _minus;
  }
  
  public int consumptionOf(final String name) {
    int _xblockexpression = (int) 0;
    {
      List<CoffeeDrinker> _coffeeDrinkers = this.getCoffeeDrinkers();
      boolean _isEmpty = _coffeeDrinkers.isEmpty();
      if (_isEmpty) {
        return 0;
      }
      List<CoffeeDrinker> _coffeeDrinkers_1 = this.getCoffeeDrinkers();
      final Function1<CoffeeDrinker,Boolean> _function = new Function1<CoffeeDrinker,Boolean>() {
          public Boolean apply(final CoffeeDrinker it) {
            String _name = it.getName();
            boolean _equals = Objects.equal(_name, name);
            return Boolean.valueOf(_equals);
          }
        };
      CoffeeDrinker _findFirst = IterableExtensions.<CoffeeDrinker>findFirst(_coffeeDrinkers_1, _function);
      int _coffeeCount = _findFirst.getCoffeeCount();
      _xblockexpression = (_coffeeCount);
    }
    return _xblockexpression;
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
