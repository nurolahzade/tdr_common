package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Position;

@Remote
public interface PositionServiceRemote {

	public Position create(Integer start, Integer length);
	
}
