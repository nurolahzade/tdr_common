package ca.ucalgary.cpsc.ase.common.service.remote;

import javax.ejb.Remote;

@Remote
public interface MyTestServiceRemote {
	
	public String getCurrentTime();
    public void doSomeDbTask();

}
