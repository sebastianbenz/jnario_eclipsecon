package coffee;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class CoffeeDrinker {
  private final String _name;
  
  public String getName() {
    return this._name;
  }
  
  private final int _coffeeCount;
  
  public int getCoffeeCount() {
    return this._coffeeCount;
  }
  
  public CoffeeDrinker(final String name, final int coffeeCount) {
    super();
    this._name = name;
    this._coffeeCount = coffeeCount;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
    result = prime * result + _coffeeCount;
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
    CoffeeDrinker other = (CoffeeDrinker) obj;
    if (_name == null) {
      if (other._name != null)
        return false;
    } else if (!_name.equals(other._name))
      return false;
    if (other._coffeeCount != _coffeeCount)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
