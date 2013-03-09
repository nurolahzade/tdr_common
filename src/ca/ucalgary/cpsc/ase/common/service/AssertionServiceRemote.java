package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Assertion;
import ca.ucalgary.cpsc.ase.common.entity.AssertionType;

@Remote
public interface AssertionServiceRemote {

	public Assertion create(AssertionType type);

	public Assertion find(AssertionType type);

	public Assertion createOrGet(AssertionType type);

}
