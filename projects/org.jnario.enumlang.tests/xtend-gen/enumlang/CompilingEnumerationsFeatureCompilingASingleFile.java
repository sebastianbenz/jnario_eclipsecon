package enumlang;

import enumlang.WorkspaceHelper;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
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
@Named("Scenario: Compiling a single file")
@SuppressWarnings("all")
public class CompilingEnumerationsFeatureCompilingASingleFile {
  @Test
  @Order(0)
  @Named("Given a selected file \\\"example/Colors.enum\\\" with")
  public void givenASelectedFileExampleColorsEnumWith() {
    StepArguments _stepArguments = new StepArguments("example/Colors.enum", "\n\t\t\tColors : BLUE, RED, GREEN\n\t\t");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _second = JnarioIterableExtensions.<String>second(args);
    IFile _createFile = this._workspaceHelper.createFile(_first, _second);
    this.selection.add(_createFile);
  }
  
  @Test
  @Order(1)
  @Named("When I compile the selected file[s]")
  public void whenICompileTheSelectedFileS() {
    CompileAction _compileAction = new CompileAction();
    final CompileAction action = _compileAction;
    IAction __ = Should.<IAction>_();
    StructuredSelection _structuredSelection = new StructuredSelection(((Object[])Conversions.unwrapArray(this.selection, Object.class)));
    action.selectionChanged(__, _structuredSelection);
    IAction ___1 = Should.<IAction>_();
    action.run(___1);
  }
  
  @Test
  @Order(2)
  @Named("Then I get a file \\\"example/Colors.java\\\" with")
  public void thenIGetAFileExampleColorsJavaWith() {
    StepArguments _stepArguments = new StepArguments("example/Colors.java", "\n\t\t\tpackage enums;\n\t\t\tpublic class Colors{\n\t\t\t\tBLUE, RED, GREEN;\n\t\t\t}\n\t\t");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _fileContents = this._workspaceHelper.getFileContents(_first);
    String _second = JnarioIterableExtensions.<String>second(args);
    boolean _doubleArrow = Should.operator_doubleArrow(_fileContents, _second);
    Assert.assertTrue("\nExpected getFileContents(args.first) => args.second but"
     + "\n     getFileContents(args.first) is " + new StringDescription().appendValue(_fileContents).toString()
     + "\n      is " + new StringDescription().appendValue(this._workspaceHelper).toString()
     + "\n     args.first is " + new StringDescription().appendValue(_first).toString()
     + "\n     args is " + new StringDescription().appendValue(args).toString()
     + "\n     args.second is " + new StringDescription().appendValue(_second).toString() + "\n", _doubleArrow);
    
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
