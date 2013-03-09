package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

@Remote
public interface MyTestServiceRemote {
	
	public String getCurrentTime();
    public void doSomeDbTask();

}
