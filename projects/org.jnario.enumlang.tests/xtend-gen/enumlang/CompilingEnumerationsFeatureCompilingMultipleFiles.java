package enumlang;

import enumlang.WorkspaceHelper;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.hamcrest.StringDescription;
import org.jnario.enumlang.popup.actions.CompileAction;
import org.jnario.lib.JnarioCollectionLiterals;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.lib.StepArguments;
import org.jnario.runner.Extension;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Compiling multiple files")
@SuppressWarnings("all")
public class CompilingEnumerationsFeatureCompilingMultipleFiles {
  @Test
  @Order(0)
  @Named("Given a selected file \"example/Colors.enum\" with")
  public void givenASelectedFileExampleColorsEnumWith() {
    StepArguments _stepArguments = new StepArguments("example/Colors.enum", "\n\t\t\tColors : BLUE, RED, GREEN\n\t\t");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _second = JnarioIterableExtensions.<String>second(args);
    final IFile file = this._workspaceHelper.createFile(_first, _second);
    this.selection.add(file);
  }
  
  @Test
  @Order(1)
  @Named("And a selected file \"example/Animals.enum\" with")
  public void andASelectedFileExampleAnimalsEnumWith() {
    StepArguments _stepArguments = new StepArguments("example/Animals.enum", "\n\t\t\tAnimals : DOG, CAT, HORSE\n\t\t");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _second = JnarioIterableExtensions.<String>second(args);
    final IFile file = this._workspaceHelper.createFile(_first, _second);
    this.selection.add(file);
  }
  
  @Test
  @Order(2)
  @Named("When I compile the selected file[s]")
  public void whenICompileTheSelectedFileS() {
    CompileAction _compileAction = new CompileAction();
    final CompileAction action = _compileAction;
    StructuredSelection _structuredSelection = new StructuredSelection(((Object[])Conversions.unwrapArray(this.selection, Object.class)));
    action.selectionChanged(null, _structuredSelection);
    action.run(null);
  }
  
  @Test
  @Order(3)
  @Named("Then I get a file \"example/Colors.java\" with")
  public void thenIGetAFileExampleColorsJavaWith() {
    StepArguments _stepArguments = new StepArguments("example/Colors.java", "\n\t\t\tpackage enums;\n\t\t\tpublic class Colors{\n\t\t\t\tBLUE, RED, GREEN;\n\t\t\t}\n\t\t");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _fileContents = this._workspaceHelper.getFileContents(_first);
    String _second = JnarioIterableExtensions.<String>second(args);
    boolean _doubleArrow = Should.operator_doubleArrow(_fileContents, _second);
    Assert.assertTrue("\nExpected  but"
     + "\n      is " + new StringDescription().appendValue(_fileContents).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Order(4)
  @Named("And I get a file \"example/Animals.java\" with")
  public void andIGetAFileExampleAnimalsJavaWith() {
    StepArguments _stepArguments = new StepArguments("example/Animals.java", "\n\t\t\tpackage enums;\n\t\t\tpublic class Colors{\n\t\t\t\tDOG, CAT, HORSE;\n\t\t\t}\n\t\t");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _fileContents = this._workspaceHelper.getFileContents(_first);
    String _second = JnarioIterableExtensions.<String>second(args);
    boolean _doubleArrow = Should.operator_doubleArrow(_fileContents, _second);
    Assert.assertTrue("\nExpected  but"
     + "\n      is " + new StringDescription().appendValue(_fileContents).toString() + "\n", _doubleArrow);
    
  }
  
  @Extension
  public WorkspaceHelper _workspaceHelper = new Function0<WorkspaceHelper>() {
    public WorkspaceHelper apply() {
      WorkspaceHelper _workspaceHelper = new WorkspaceHelper();
      return _workspaceHelper;
    }
  }.apply();
  
  final List<Object> selection = new Function0<List<Object>>() {
    public List<Object> apply() {
      List<Object> _list = JnarioCollectionLiterals.<Object>list();
      return _list;
    }
  }.apply();
}
