package expenses;

import com.google.common.base.Objects;
import expenses.Expense;
import expenses.Expenses;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ExpenseParser {
  public void parse(final Expenses expenses, final String input) {
    boolean _equals = Objects.equal(input, null);
    if (_equals) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException();
      throw _illegalArgumentException;
    }
    final String[] expenseStrings = input.split("\n");
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          ExpenseParser.this.addTo(it, expenses);
        }
      };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(expenseStrings)), _function);
  }
  
  public boolean addTo(final String expenseString, final Expenses expenses) {
    boolean _xblockexpression = false;
    {
      String[] _split = expenseString.split(",");
      Iterator<String> _iterator = ((List<String>)Conversions.doWrapArray(_split)).iterator();
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String it) {
            String _trim = it.trim();
            return _trim;
          }
        };
      final Iterator<String> entries = IteratorExtensions.<String, String>map(_iterator, _function);
      String _next = entries.next();
      String _next_1 = entries.next();
      Integer _valueOf = Integer.valueOf(_next_1);
      Expense _expense = new Expense(_next, (_valueOf).intValue());
      final Expense expense = _expense;
      boolean _add = expenses.add(expense);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
}
