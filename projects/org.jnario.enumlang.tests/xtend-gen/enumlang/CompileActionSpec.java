package enumlang;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jnario.enumlang.popup.actions.CompileAction;
import org.jnario.enumlang.popup.actions.EnumCompiler;
import org.jnario.lib.JnarioCollectionLiterals;
import org.jnario.lib.Should;
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
  
  final EnumCompiler compiler = Mockito.mock(EnumCompiler.class);
  
  @Before
  public void before() throws Exception {
    CompileAction _compileAction = new CompileAction(this.compiler);
    this.subject = _compileAction;
  }
  
  @Test
  @Named("passes selected files to compiler")
  @Order(99)
  public void _passesSelectedFilesToCompiler() throws Exception {
    final List<IFile> selectedFiles = JnarioCollectionLiterals.<IFile>list(Mockito.mock(IFile.class), Mockito.mock(IFile.class));
    StructuredSelection _structuredSelection = new StructuredSelection(selectedFiles);
    final StructuredSelection selection = _structuredSelection;
    IAction __ = Should.<IAction>_();
    this.subject.selectionChanged(__, selection);
    IAction ___1 = Should.<IAction>_();
    this.subject.run(___1);
    EnumCompiler _verify = Mockito.<EnumCompiler>verify(this.compiler);
    final Procedure1<EnumCompiler> _function = new Procedure1<EnumCompiler>() {
        public void apply(final EnumCompiler it) {
          it.compile(selectedFiles);
        }
      };
    ObjectExtensions.<EnumCompiler>operator_doubleArrow(_verify, _function);
  }
}
