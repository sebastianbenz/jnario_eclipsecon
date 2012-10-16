package enumlang.util;

import com.google.common.base.Objects;
import java.io.InputStream;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
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
import org.jnario.enumlang.utils.StringInputStream;
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
    final String[] segments = path.split("/");
    IContainer container = null;
    for (final String segment : segments) {
      boolean _matched = false;
      if (!_matched) {
        String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(segments)));
        if (Objects.equal(segment,_head)) {
          _matched=true;
          String _head_1 = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(segments)));
          IProject _createProject = this.createProject(_head_1);
          container = _createProject;
        }
      }
      if (!_matched) {
        String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(segments)));
        if (Objects.equal(segment,_last)) {
          _matched=true;
          return this.createFile(container, segment, content);
        }
      }
      if (!_matched) {
        IFolder _createFolder = this.createFolder(container, segment);
        container = _createFolder;
      }
    }
    return null;
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
  
  public IFolder createFolder(final IContainer container, final String name) {
    try {
      IFolder _xblockexpression = null;
      {
        Path _path = new Path(name);
        final IFolder folder = container.getFolder(_path);
        boolean _exists = folder.exists();
        if (_exists) {
          return folder;
        }
        NullProgressMonitor _monitor = this.monitor();
        folder.create(true, true, _monitor);
        _xblockexpression = (folder);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IFile createFile(final IContainer container, final String name, final String content) {
    try {
      IFile _xblockexpression = null;
      {
        StringInputStream _stringInputStream = new StringInputStream(content);
        final StringInputStream contentStream = _stringInputStream;
        Path _path = new Path(name);
        final IFile file = container.getFile(_path);
        boolean _exists = file.exists();
        if (_exists) {
          NullProgressMonitor _monitor = this.monitor();
          file.setContents(contentStream, true, false, _monitor);
        } else {
          NullProgressMonitor _monitor_1 = this.monitor();
          file.create(contentStream, true, _monitor_1);
        }
        _xblockexpression = (file);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IProject createProject(final String name) {
    try {
      IProject _xblockexpression = null;
      {
        final IProject project = this.workspaceRoot.getProject(name);
        boolean _exists = project.exists();
        boolean _not = (!_exists);
        if (_not) {
          NullProgressMonitor _monitor = this.monitor();
          project.create(_monitor);
          NullProgressMonitor _monitor_1 = this.monitor();
          project.open(_monitor_1);
        }
        _xblockexpression = (project);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public NullProgressMonitor monitor() {
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    return _nullProgressMonitor;
  }
}
