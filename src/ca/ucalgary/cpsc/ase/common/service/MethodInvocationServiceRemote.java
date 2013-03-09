package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Assertion;
import ca.ucalgary.cpsc.ase.common.entity.Method;
import ca.ucalgary.cpsc.ase.common.entity.MethodInvocation;
import ca.ucalgary.cpsc.ase.common.entity.Position;
import ca.ucalgary.cpsc.ase.common.entity.TestMethod;

@Remote
public interface MethodInvocationServiceRemote {

	public MethodInvocation create(TestMethod tm, Method m, Assertion a,
			Position p);

}
