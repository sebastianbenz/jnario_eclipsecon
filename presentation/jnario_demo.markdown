#Jnario Demo

##Specs Demo

##Feature Demo & Outside-in Example

We want to implement a DSL to simplify the declaration of enumerations in Java. 

###Given, When, Then... 

- Goal: Introduce Given, When, Then
- Explain:
	- Idea behind given when then
	- Importance of narrative

<pre class="prettyprint lang-feature">
Feature: Compiling Enumerations

In order to develop faster 
as a Java programmer
I want a concise syntax for enumerations

Scenario: Compiling a single file	
	Given a selected file "example/Colors.enum" with
	'''
		Colors : BLUE, RED, GREEN
	'''
	When I execute the compile action
	Then I get a file "example/Colors.java" with
	'''
		package enums;
		
		public enum Colors {
			BLUE, RED, GREEN
		}
	'''
</pre>

###Inline Implementation

- Goal: Demonstrate how to implement steps inline. 
- Explain:
	- how to access parameters defined in steps
	- how to 
	- how scenarios and steps are translated into Java. 
	- extension fields
- Do:
	- implement steps
	- Fix compile error by creating CompileAction using the corresponding Eclipse wizard.
	- Run as JUnit test.

<pre class="prettyprint lang-feature">
...

Scenario: Compiling a single file
	extension WorkspaceHelper = new WorkspaceHelper
	val selection = list()
			
	Given a selected file "example/Colors.enum" with
	'''
		Colors : BLUE, RED, GREEN
	'''
		selection += createFile(args.first, args.second)
	When I execute the compile action
		val action = new CompileAction
		action.selectionChanged(_, new StructuredSelection(selection))
		action.run(_)
	Then I get a file "example/Colors.java" with
	'''
		package enums;
		
		public enum Colors {
			BLUE, RED, GREEN
		}
	'''
		getFileContents(args.first) => args.second
</pre>

###Reusing Steps

- Goal: Show how to create new scenarios by reusing existing steps.
- Explain:
	- how references work (copying of fields)
	- 
- Do:
	- Add scenario 
	- Use code completion to create steps
	- Execute scenario 
		-> strange error during setup step of second scenario
		-> workspace is not properly cleaned
		-> we need a setup method

###Cleaner Specs with Extensions

- Gloal: Explain role of extensions in Jnario
- Explain:
	- Setup & teardown methods can be defined in extension classes
	- Great way to encapsulate test setup and tear down
- Do:
	- Open WorkspaceHelper.xtend
	- Uncomment setup method
	- Run test -> exception in given step is gone

<pre class="prettyprint lang-xtend">
class WorkspaceHelper {
	
	val workspaceRoot = ResourcesPlugin::workspace.root
	
	@Before
	def clearWorkspace(){
		workspaceRoot.projects.forEach[delete(true, monitor)]
	}	

	...
</pre>

###Summary 1

- So far we have seen how you can use Jnario to define the acceptance criteria for your new feature.
- Features are defined in prose so everyone can understand them. This makes them suitable as a means to flesh out the expected behavior of your application together with your customer.
- Next step is to implement the actual behavior of your application. 
- Here we won't use features as we shift the focus from the user perspective to the developer perspective. 

###Compiler Action Spec

- Fact: passes selected file's contents to compiler

- Fact: wraps core exceptions in runtime exception

- Fact: writes compilation result to java file with same name as input


