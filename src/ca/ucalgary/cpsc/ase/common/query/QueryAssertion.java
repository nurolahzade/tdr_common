package ca.ucalgary.cpsc.ase.common.query;

import ca.ucalgary.cpsc.ase.common.entity.AssertionType;

public class QueryAssertion extends QueryInvocation {

	private static final long serialVersionUID = -113944632599685457L;

	private AssertionType type;

	public AssertionType getType() {
		return type;
	}

	public void setType(AssertionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type.getName();
	}

	@Override
	public String getCaption() {
		return "Assertions";
	}

}
