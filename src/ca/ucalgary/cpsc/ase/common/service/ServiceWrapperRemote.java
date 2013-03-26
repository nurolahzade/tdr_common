package ca.ucalgary.cpsc.ase.common.service;

import java.util.List;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Assertion;
import ca.ucalgary.cpsc.ase.common.entity.AssertionType;
import ca.ucalgary.cpsc.ase.common.entity.Clazz;
import ca.ucalgary.cpsc.ase.common.entity.Method;
import ca.ucalgary.cpsc.ase.common.entity.MethodInvocation;
import ca.ucalgary.cpsc.ase.common.entity.ObjectType;
import ca.ucalgary.cpsc.ase.common.entity.Position;
import ca.ucalgary.cpsc.ase.common.entity.Project;
import ca.ucalgary.cpsc.ase.common.entity.Reference;
import ca.ucalgary.cpsc.ase.common.entity.RepositoryFile;
import ca.ucalgary.cpsc.ase.common.entity.SourceFile;
import ca.ucalgary.cpsc.ase.common.entity.TestMethod;
import ca.ucalgary.cpsc.ase.common.entity.Xception;

@Remote
public interface ServiceWrapperRemote {

	//AssertionService
	public Assertion createAssertion(AssertionType type);
	public Assertion findAssertion(AssertionType type);
	public Assertion createOrGetAssertion(AssertionType type);
	
	//ClazzService
	public Clazz createClazz(String className, String packageName, String fqn,
			SourceFile source, ObjectType type);
	public Clazz createOrGetClazz(String className, String packageName, String fqn,
			SourceFile source, ObjectType type);
	public Clazz findClazz(String fqn);
	
	//MethodInvocationService
	public MethodInvocation createInvocation(TestMethod tm, Method m, Assertion a,
			Position p);	
	public void addDataFlowRelationship(MethodInvocation from, MethodInvocation to);
	
	//MethodService
	public Method createMethod(String name, Clazz clazz, Clazz returnType,
			boolean isConstructor, List<Clazz> arguments, int hash);
	public Method createOrGetMethod(String name, Clazz clazz, Clazz returnType,
			boolean isConstructor, List<Clazz> arguments, int hash);
	public List<Method> findMethod(String name, String fqn, List<String> arguments);
	
	//PositionService
	public Position createPosition(Integer start, Integer length);
	
	//ProjectService
	public Project createProject(String name);
	
	//ReferenceService
	public Reference createReference(String name, Clazz clazz, Clazz declaringClazz,
			TestMethod testMethod, Position position);
	public Reference createOrGetReference(String name, Clazz clazz,
			Clazz declaringClazz, TestMethod testMethod, Position position);
	public Reference findReference(String name, Clazz clazz, Clazz declaringClazz,
			TestMethod testMethod);
	
	//RepositoryFileService
	public RepositoryFile createRepositoryFile(String path);
	public void visitRepositoryFile(RepositoryFile file);
	public void skipRepositoryFile(RepositoryFile file);
	public List<RepositoryFile> findUnvisitedRepositoryFile(int maxResults);
	
	//SourceFileService
	public SourceFile createSourceFile(Project project, String path);
	
	//TestMethodService
	public TestMethod createTestMethod(String name, Clazz testClass, Position position);
	
	//XceptionService
	public Xception createXception(Clazz clazz, TestMethod method);
	public Xception createOrGetXception(Clazz clazz, TestMethod testMethod);
	public Xception findXception(Clazz clazz);	
	
	public void rollbackTransaction();
	public void commitTransaction();
	public void startTransaction();

}
