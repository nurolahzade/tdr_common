package ca.ucalgary.cpsc.ase.common.query;

public class QueryTestMethod extends QueryElement {
	
	private static final long serialVersionUID = 2248853977744399794L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("()");
		return builder.toString();
	}

	@Override
	public String getCaption() {
		return "Test Method";
	}

}
