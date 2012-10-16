package enumlang.util

import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.junit.Before

import static extension org.jnario.enumlang.utils.Strings.*
import org.jnario.enumlang.utils.StringInputStream

class WorkspaceHelper {
	
	val workspaceRoot = ResourcesPlugin::workspace.root
	
	@Before
	def clearWorkspace(){
		workspaceRoot.projects.forEach[delete(true, monitor)]
	}	
	
	def createFile(String path, String content){
		val segments = path.split("/")
		var IContainer container
		for(segment: segments){
			switch(segment) {
				case segments.head: container = createProject(segments.head)
				case segments.last: return container.createFile(segment, content)
				default: container = container.createFolder(segment)
			}
		}
		return null
	}
	
	def getFile(String path){
		workspaceRoot.getFile(new Path(path))
	}
	
	def getFileContents(String path){
		val file = path.getFile
		file.contents.convertToString
	}
	
	def createFolder(IContainer container, String name){
		val folder = container.getFolder(new Path(name))
		if(folder.exists){
			return folder
		}
		folder.create(true, true, monitor)
		folder
	}

	def createFile(IContainer container, String name, String content){
		val contentStream = new StringInputStream(content)
		val file = container.getFile(new Path(name))
		if(file.exists){
			file.setContents(contentStream, true, false, monitor)
		}else{
			file.create(contentStream, true, monitor)
		}
		file
	}
		
	def createProject(String name){
		val project = workspaceRoot.getProject(name)
		if(!project.exists){
			project.create(monitor)
			project.open(monitor)
		}	
		project
	}

	def monitor() {
		new NullProgressMonitor
	}
}