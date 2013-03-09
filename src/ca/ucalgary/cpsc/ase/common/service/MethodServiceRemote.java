package ca.ucalgary.cpsc.ase.common.service;

import java.util.List;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Clazz;
import ca.ucalgary.cpsc.ase.common.entity.Method;

@Remote
public interface MethodServiceRemote {

	public Method create(String name, Clazz clazz, Clazz returnType,
			boolean isConstructor, List<Clazz> arguments, int hash);

	public Method createOrGet(String name, Clazz clazz, Clazz returnType,
			boolean isConstructor, List<Clazz> arguments, int hash);

	public List<Method> find(String name, String fqn, List<String> arguments);

}
