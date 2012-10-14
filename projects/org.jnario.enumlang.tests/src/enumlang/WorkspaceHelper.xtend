package enumlang

import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.xbase.lib.Procedures$Procedure1
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.Path
import org.junit.Before
import static extension org.jnario.enumlang.utils.Strings.*

class WorkspaceHelper {
	
	val workspaceRoot = ResourcesPlugin::workspace.root
	
	@Before
	def clearWorkspace(){
		workspaceRoot.projects.forEach[delete(true, monitor)]
	}	
	
	def createFile(String path, String content){
		val segments = path.split("/")
		project(segments.head)[
			file(segments.last, content)
		]
		path.getFile
	}
	
	def getFile(String path){
		workspaceRoot.getFile(new Path(path))
	}
	
	def getFileContents(String path){
		val file = path.getFile
		file.contents.convertToString
	}
	
	def project(String name, Procedures$Procedure1<IProject> projectInitializer){
		val project = workspaceRoot.getProject(name)
		if(!project.exists){
			project.create(monitor)
			project.open(monitor)
		}	
		projectInitializer.apply(project)
	}


	def file(IProject project, String name, CharSequence content){
		val input = new StringInputStream(content.toString)
		project.getFile(name).create(input, true, monitor)
	}
	
	def monitor() {
		new NullProgressMonitor
	}
}