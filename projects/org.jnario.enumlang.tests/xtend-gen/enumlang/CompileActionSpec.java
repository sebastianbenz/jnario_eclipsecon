package enumlang;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.jnario.enumlang.popup.actions.CompileAction;
import org.jnario.enumlang.popup.actions.EnumCompiler;
import org.jnario.lib.JnarioCollectionLiterals;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("CompileAction")
public class CompileActionSpec {
  public CompileAction subject;
  
  final EnumCompiler compiler = new Function0<EnumCompiler>() {
    public EnumCompiler apply() {
      EnumCompiler _mock = Mockito.<EnumCompiler>mock(EnumCompiler.class);
      return _mock;
    }
  }.apply();
  
  @Before
  public void before() throws Exception {
    CompileAction _compileAction = new CompileAction(this.compiler);
    this.subject = _compileAction;
  }
  
  @Test
  @Named("passes selected files to compiler")
  @Order(99)
  public void _passesSelectedFilesToCompiler() throws Exception {
    IFile _mock = Mockito.<IFile>mock(IFile.class);
    IFile _mock_1 = Mockito.<IFile>mock(IFile.class);
    final List<IFile> selectedFiles = JnarioCollectionLiterals.<IFile>list(_mock, _mock_1);
    StructuredSelection _structuredSelection = new StructuredSelection(selectedFiles);
    final StructuredSelection selection = _structuredSelection;
    this.subject.selectionChanged(null, selection);
    this.subject.run(null);
    EnumCompiler _verify = Mockito.<EnumCompiler>verify(this.compiler);
    _verify.compile(selectedFiles);
  }
}
