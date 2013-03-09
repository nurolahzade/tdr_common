package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Clazz;
import ca.ucalgary.cpsc.ase.common.entity.Position;
import ca.ucalgary.cpsc.ase.common.entity.TestMethod;

@Remote
public interface TestMethodServiceRemote {

	public TestMethod create(String name, Clazz testClass, Position position);

}
