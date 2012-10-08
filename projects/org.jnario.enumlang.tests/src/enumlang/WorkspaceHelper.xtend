package enumlang

import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.xbase.lib.Procedures$Procedure1
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.Path
import java.io.InputStream

class WorkspaceHelper {
	
	val root = ResourcesPlugin::workspace.root
	
	def createFile(String path, String content){
		val segments = path.split("/")
		project(segments.head)[
			file(segments.last, content)
		]
		path.getFile
	}
	
	def getFile(String path){
		root.getFile(new Path(path))
	}
	
	def getFileContents(String path){
		val file = path.getFile
		file.contents.convertToString
	}
	
	def convertToString(InputStream is){
	    try {
	        return new java.util.Scanner(is).useDelimiter("\\A").next();
	    } catch (java.util.NoSuchElementException e) {
	        return ""
		}
	}
	
	def project(String name, Procedures$Procedure1<IProject> projectInitializer){
		val project = root.getProject(name)
		project.create(monitor)
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