package ca.ucalgary.cpsc.ase.common.query;

public class QueryException extends QueryElement {

	private static final long serialVersionUID = 7884743302710271981L;

	private String clazzFqn;

	public String getClazzFqn() {
		return clazzFqn;
	}

	public void setClazzFqn(String clazzFqn) {
		this.clazzFqn = clazzFqn;
	}

	@Override
	public String toString() {
		return clazzFqn;
	}

	@Override
	public String getCaption() {
		return "Exceptions";
	}		
	
}
