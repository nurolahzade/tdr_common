package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Clazz;
import ca.ucalgary.cpsc.ase.common.entity.ObjectType;
import ca.ucalgary.cpsc.ase.common.entity.SourceFile;

@Remote
public interface ClazzServiceRemote {

	public Clazz create(String className, String packageName, String fqn,
			SourceFile source, ObjectType type);

	public Clazz createOrGet(String className, String packageName, String fqn,
			SourceFile source, ObjectType type);

	public Clazz find(String fqn);

}
