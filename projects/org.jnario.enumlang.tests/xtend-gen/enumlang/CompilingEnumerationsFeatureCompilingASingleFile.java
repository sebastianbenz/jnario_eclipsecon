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
@Named("Scenario: Compiling a single file")
@SuppressWarnings("all")
public class CompilingEnumerationsFeatureCompilingASingleFile {
  @Test
  @Order(0)
  @Named("Given a selected file \"example/MyEnum.enum\" with")
  public void givenASelectedFileExampleMyEnumEnumWith() {
    StepArguments _stepArguments = new StepArguments("example/MyEnum.enum", "\n\t\t\tColors : BLUE, RED, GREEN\n\t\t");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _second = JnarioIterableExtensions.<String>second(args);
    final IFile file = this.helper.createFile(_first, _second);
    this.selection.add(file);
  }
  
  @Test
  @Order(1)
  @Named("When I compile \"example/MyEnum.enum\"")
  public void whenICompileExampleMyEnumEnum() {
    StepArguments _stepArguments = new StepArguments("example/MyEnum.enum");
    final StepArguments args = _stepArguments;
    CompileAction _compileAction = new CompileAction();
    final CompileAction action = _compileAction;
    StructuredSelection _structuredSelection = new StructuredSelection(((Object[])Conversions.unwrapArray(this.selection, Object.class)));
    action.selectionChanged(null, _structuredSelection);
    action.run(null);
  }
  
  @Test
  @Order(2)
  @Named("Then I get a file \"example/MyEnum.java\" with")
  public void thenIGetAFileExampleMyEnumJavaWith() {
    StepArguments _stepArguments = new StepArguments("example/MyEnum.java", "\n\t\t\tpackage enums;\n\t\t\tpublic class Colors{\n\t\t\t\tBLUE, RED, GREEN;\n\t\t\t}\n\t\t");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _fileContents = this.helper.getFileContents(_first);
    String _second = JnarioIterableExtensions.<String>second(args);
    boolean _doubleArrow = Should.operator_doubleArrow(_fileContents, _second);
    Assert.assertTrue("\nExpected getFileContents(args.first) => args.second but"
     + "\n     getFileContents(args.first) is " + new StringDescription().appendValue(_fileContents).toString()
     + "\n      is " + new StringDescription().appendValue(this.helper).toString()
     + "\n     args.first is " + new StringDescription().appendValue(_first).toString()
     + "\n     args is " + new StringDescription().appendValue(args).toString()
     + "\n     args.second is " + new StringDescription().appendValue(_second).toString() + "\n", _doubleArrow);
    
  }
  
  @Extension
  public WorkspaceHelper helper = new Function0<WorkspaceHelper>() {
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
