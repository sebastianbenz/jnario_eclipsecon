package enumlang;

import enumlang.StringInputStream;
import java.io.InputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jnario.enumlang.utils.Strings;
import org.junit.Before;

@SuppressWarnings("all")
public class WorkspaceHelper {
  private final IWorkspaceRoot workspaceRoot = new Function0<IWorkspaceRoot>() {
    public IWorkspaceRoot apply() {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      return _root;
    }
  }.apply();
  
  @Before
  public void clearWorkspace() {
    IProject[] _projects = this.workspaceRoot.getProjects();
    final Procedure1<IProject> _function = new Procedure1<IProject>() {
        public void apply(final IProject it) {
          try {
            NullProgressMonitor _monitor = WorkspaceHelper.this.monitor();
            it.delete(true, _monitor);
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    IterableExtensions.<IProject>forEach(((Iterable<IProject>)Conversions.doWrapArray(_projects)), _function);
  }
  
  public IFile createFile(final String path, final String content) {
    IFile _xblockexpression = null;
    {
      final String[] segments = path.split("/");
      String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(segments)));
      final Procedure1<IProject> _function = new Procedure1<IProject>() {
          public void apply(final IProject it) {
            String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(segments)));
            WorkspaceHelper.this.file(it, _last, content);
          }
        };
      this.project(_head, _function);
      IFile _file = this.getFile(path);
      _xblockexpression = (_file);
    }
    return _xblockexpression;
  }
  
  public IFile getFile(final String path) {
    Path _path = new Path(path);
    IFile _file = this.workspaceRoot.getFile(_path);
    return _file;
  }
  
  public String getFileContents(final String path) {
    try {
      String _xblockexpression = null;
      {
        final IFile file = this.getFile(path);
        InputStream _contents = file.getContents();
        String _convertToString = Strings.convertToString(_contents);
        _xblockexpression = (_convertToString);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void project(final String name, final Procedure1<IProject> projectInitializer) {
    try {
      final IProject project = this.workspaceRoot.getProject(name);
      boolean _exists = project.exists();
      boolean _not = (!_exists);
      if (_not) {
        NullProgressMonitor _monitor = this.monitor();
        project.create(_monitor);
        NullProgressMonitor _monitor_1 = this.monitor();
        project.open(_monitor_1);
      }
      projectInitializer.apply(project);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void file(final IProject project, final String name, final CharSequence content) {
    try {
      String _string = content.toString();
      StringInputStream _stringInputStream = new StringInputStream(_string);
      final StringInputStream input = _stringInputStream;
      IFile _file = project.getFile(name);
      NullProgressMonitor _monitor = this.monitor();
      _file.create(input, true, _monitor);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public NullProgressMonitor monitor() {
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    return _nullProgressMonitor;
  }
}
