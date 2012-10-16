package expenses;

import com.google.common.collect.HashMultimap;
import expenses.Expense;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Expenses {
  private int sum = 0;
  
  private final HashMultimap<String,Integer> expenses2Name = new Function0<HashMultimap<String,Integer>>() {
    public HashMultimap<String,Integer> apply() {
      HashMultimap<String,Integer> _create = HashMultimap.<String, Integer>create();
      return _create;
    }
  }.apply();
  
  public int overall() {
    return this.sum;
  }
  
  public boolean add(final Expense expense) {
    boolean _xblockexpression = false;
    {
      int _value = expense.getValue();
      int _plus = (this.sum + _value);
      this.sum = _plus;
      String _name = expense.getName();
      int _value_1 = expense.getValue();
      boolean _put = this.expenses2Name.put(_name, Integer.valueOf(_value_1));
      _xblockexpression = (_put);
    }
    return _xblockexpression;
  }
  
  public int of(final String name) {
    Integer _xblockexpression = null;
    {
      final Set<Integer> expenses = this.expenses2Name.get(name);
      boolean _isEmpty = expenses.isEmpty();
      if (_isEmpty) {
        return 0;
      }
      final Function2<Integer,Integer,Integer> _function = new Function2<Integer,Integer,Integer>() {
          public Integer apply(final Integer a, final Integer b) {
            int _plus = ((a).intValue() + (b).intValue());
            return Integer.valueOf(_plus);
          }
        };
      Integer _reduce = IterableExtensions.<Integer>reduce(expenses, _function);
      _xblockexpression = (_reduce);
    }
    return _xblockexpression;
  }
}
