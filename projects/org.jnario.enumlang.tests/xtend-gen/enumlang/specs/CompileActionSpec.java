package enumlang.specs;

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
import org.jnario.enumlang.popup.actions.EnumParser;
import org.jnario.enumlang.popup.actions.MyEnum;
import org.jnario.enumlang.utils.FileSystemAccess;
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
  
  EnumParser enumParser = Mockito.mock(EnumParser.class);
  
  EnumCompiler enumCompiler = Mockito.mock(EnumCompiler.class);
  
  FileSystemAccess fileSystemAccess = Mockito.mock(FileSystemAccess.class);
  
  final CompileAction compileAction = new Function0<CompileAction>() {
    public CompileAction apply() {
      CompileAction _compileAction = new CompileAction(CompileActionSpec.this.enumCompiler, CompileActionSpec.this.enumParser, CompileActionSpec.this.fileSystemAccess);
      return _compileAction;
    }
  }.apply();
  
  final String fileContent = "file content";
  
  IFile inputFile = new Function0<IFile>() {
    public IFile apply() {
      IFile _createFile = CompileActionSpec.this._workspaceHelper.createFile("examples/src/MyEnum.enum", CompileActionSpec.this.fileContent);
      return _createFile;
    }
  }.apply();
  
  @Test
  @Named("passes selected file\\\'s contents to parser")
  @Order(0)
  public void _passesSelectedFileSContentsToParser() throws Exception {
    this.executeCompileAction(this.inputFile);
    EnumParser _verify = Mockito.<EnumParser>verify(this.enumParser);
    _verify.parse(this.fileContent);
  }
  
  @Test
  @Named("wraps core exceptions in runtime exception")
  @Order(1)
  public void _wrapsCoreExceptionsInRuntimeException() throws Exception {
    final Procedure1<IFile> _function = new Procedure1<IFile>() {
        public void apply(final IFile it) {
          try {
            InputStream _contents = it.getContents();
            OngoingStubbing<InputStream> _when = Mockito.<InputStream>when(_contents);
            CoreException _coreException = new CoreException(Status.OK_STATUS);
            _when.thenThrow(_coreException);
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    IFile _doubleArrow = ObjectExtensions.<IFile>operator_doubleArrow(Mockito.mock(IFile.class), _function);
    this.inputFile = _doubleArrow;
    try{
      this.executeCompileAction(this.inputFile);
      Assert.fail("Expected " + RuntimeException.class.getName() + " in \n     inputFile.executeCompileAction\n with:"
       + "\n     inputFile is " + new StringDescription().appendValue(this.inputFile).toString());
    }catch(RuntimeException e){
      // expected
    }
  }
  
  @Test
  @Named("passes parsed enum to compiler")
  @Order(2)
  public void _passesParsedEnumToCompiler() throws Exception {
    final MyEnum parsedEnum = Mockito.mock(MyEnum.class);
    String _anyString = Matchers.anyString();
    MyEnum _parse = this.enumParser.parse(_anyString);
    OngoingStubbing<MyEnum> _when = Mockito.<MyEnum>when(_parse);
    _when.thenReturn(parsedEnum);
    this.executeCompileAction(this.inputFile);
    EnumCompiler _verify = Mockito.<EnumCompiler>verify(this.enumCompiler);
    _verify.compile(parsedEnum);
  }
  
  @Test
  @Named("writes generated java file to input folder")
  @Order(3)
  public void _writesGeneratedJavaFileToInputFolder() throws Exception {
    final MyEnum myEnum = Mockito.mock(MyEnum.class);
    String _anyString = Matchers.anyString();
    MyEnum _parse = this.enumParser.parse(_anyString);
    OngoingStubbing<MyEnum> _when = Mockito.<MyEnum>when(_parse);
    _when.thenReturn(myEnum);
    CharSequence _compile = this.enumCompiler.compile(myEnum);
    OngoingStubbing<CharSequence> _when_1 = Mockito.<CharSequence>when(_compile);
    _when_1.thenReturn(this.fileContent);
    this.executeCompileAction(this.inputFile);
    FileSystemAccess _verify = Mockito.<FileSystemAccess>verify(this.fileSystemAccess);
    _verify.createFile("src/enums/Colors.java", this.fileContent);
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
