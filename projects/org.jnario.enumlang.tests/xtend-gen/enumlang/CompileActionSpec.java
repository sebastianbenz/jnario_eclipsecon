package enumlang;

import enumlang.WorkspaceHelper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hamcrest.StringDescription;
import org.jnario.enumlang.popup.actions.CompileAction;
import org.jnario.enumlang.popup.actions.EnumCompiler;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Extension;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("CompileAction")
public class CompileActionSpec {
  @Extension
  public WorkspaceHelper _workspaceHelper = new Function0<WorkspaceHelper>() {
    public WorkspaceHelper apply() {
      WorkspaceHelper _workspaceHelper = new WorkspaceHelper();
      return _workspaceHelper;
    }
  }.apply();
  
  EnumCompiler enumCompiler = Mockito.mock(EnumCompiler.class);
  
  final CompileAction compileAction = new Function0<CompileAction>() {
    public CompileAction apply() {
      CompileAction _compileAction = new CompileAction(CompileActionSpec.this.enumCompiler);
      return _compileAction;
    }
  }.apply();
  
  @Test
  @Named("passes selected file to compiler")
  @Order(99)
  public void _passesSelectedFileToCompiler() throws Exception {
    IFile inputFile = this._workspaceHelper.createFile("example/Colors.enum", "contents");
    this.executeCompileAction(inputFile);
    EnumCompiler _verify = Mockito.<EnumCompiler>verify(this.enumCompiler);
    _verify.compile("contents");
  }
  
  @Test
  @Named("rethrows core exceptions in runtime exception")
  @Order(99)
  public void _rethrowsCoreExceptionsInRuntimeException() throws Exception {
    final Procedure1<IFile> _function = new Procedure1<IFile>() {
        public void apply(final IFile it) {
          try {
            InputStream _contents = it.getContents();
            OngoingStubbing<InputStream> _when = Mockito.<InputStream>when(_contents);
            CoreException _coreException = new CoreException(Status.OK_STATUS);
            _when.thenThrow(_coreException);
          } catch (final Throwable _t) {
            if (_t instanceof CoreException) {
              final CoreException e = (CoreException)_t;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
    final IFile invalidFile = ObjectExtensions.<IFile>operator_doubleArrow(Mockito.mock(IFile.class), _function);
    try{
      this.executeCompileAction(invalidFile);
      Assert.fail("Expected " + RuntimeException.class.getName() + " in \n     invalidFile.executeCompileAction\n with:"
       + "\n     invalidFile is " + new StringDescription().appendValue(invalidFile).toString());
    }catch(RuntimeException e){
      // expected
    }
  }
  
  @Test
  @Named("writes compilation result to java file with same name as input")
  @Order(99)
  public void _writesCompilationResultToJavaFileWithSameNameAsInput() throws Exception {
    IFile inputFile = this._workspaceHelper.createFile("example/Colors.enum", "contents");
    String _anyString = Matchers.anyString();
    CharSequence _compile = this.enumCompiler.compile(_anyString);
    OngoingStubbing<CharSequence> _when = Mockito.<CharSequence>when(_compile);
    _when.thenReturn("result string");
    this.executeCompileAction(inputFile);
    String _fileContents = this._workspaceHelper.getFileContents("example/Colors.java");
    boolean _doubleArrow = Should.operator_doubleArrow(_fileContents, "result string");
    Assert.assertTrue("\nExpected \"example/Colors.java\".fileContents => \"result string\" but"
     + "\n     \"example/Colors.java\".fileContents is " + new StringDescription().appendValue(_fileContents).toString()
     + "\n      is " + new StringDescription().appendValue(this._workspaceHelper).toString() + "\n", _doubleArrow);
    
  }
  
  public void executeCompileAction(final IFile inputFile) {
    IAction __ = Should.<IAction>_();
    StructuredSelection _structuredSelection = new StructuredSelection(inputFile);
    this.compileAction.selectionChanged(__, _structuredSelection);
    IAction ___1 = Should.<IAction>_();
    this.compileAction.run(___1);
  }
  
  public ByteArrayInputStream toInputStream(final String s) {
    byte[] _bytes = s.getBytes();
    ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
    return _byteArrayInputStream;
  }
}
