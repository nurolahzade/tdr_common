package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Clazz;
import ca.ucalgary.cpsc.ase.common.entity.Position;
import ca.ucalgary.cpsc.ase.common.entity.Reference;
import ca.ucalgary.cpsc.ase.common.entity.TestMethod;

@Remote
public interface ReferenceServiceRemote {

	public Reference create(String name, Clazz clazz, Clazz declaringClazz,
			TestMethod testMethod, Position position);

	public Reference createOrGet(String name, Clazz clazz,
			Clazz declaringClazz, TestMethod testMethod, Position position);

	public Reference find(String name, Clazz clazz, Clazz declaringClazz,
			TestMethod testMethod);
	
}
