package ca.ucalgary.cpsc.ase.common.query;

import java.io.Serializable;

public abstract class QueryElement implements Serializable {
	
	private static final long serialVersionUID = -7276402329603952035L;

	protected boolean resolved;
	
	public abstract String getCaption();
	
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	
	public boolean isResolved() {
		return resolved;
	}

}
