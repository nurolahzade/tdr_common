package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Clazz;
import ca.ucalgary.cpsc.ase.common.entity.TestMethod;
import ca.ucalgary.cpsc.ase.common.entity.Xception;

@Remote
public interface XceptionServiceRemote {

	public Xception create(Clazz clazz, TestMethod method);

	public Xception createOrGet(Clazz clazz, TestMethod testMethod);

	public Xception find(Clazz clazz);

}
