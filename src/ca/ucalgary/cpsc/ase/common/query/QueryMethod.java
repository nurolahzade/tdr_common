package ca.ucalgary.cpsc.ase.common.query;

import java.util.List;

public class QueryMethod extends QueryInvocation {

	private static final long serialVersionUID = -5584299118394502693L;

	private String name;
	private String clazzFqn;
	private String returnTypeFqn;
	private List<String> arguments;
	private int hash;
	private boolean constructor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazzFqn() {
		return clazzFqn;
	}
	public void setClazzFqn(String clazzFqn) {
		this.clazzFqn = clazzFqn;
	}
	public String getReturnTypeFqn() {
		return returnTypeFqn;
	}
	public void setReturnTypeFqn(String returnTypeFqn) {
		this.returnTypeFqn = returnTypeFqn;
	}
	public List<String> getArguments() {
		return arguments;
	}
	public void setArguments(List<String> arguments) {
		this.arguments = arguments;
	}
	public int getHash() {
		return hash;
	}
	public void setHash(int hash) {
		this.hash = hash;
	}
	public boolean isConstructor() {
		return constructor;
	}
	public void setConstructor(boolean constructor) {
		this.constructor = constructor;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (clazzFqn != null && clazzFqn.length() > 0) {
			builder.append(clazzFqn);
			builder.append(".");
		}
		builder.append(name);
		builder.append("(");
		if (arguments != null) {
			for (int i = 0; i < arguments.size(); ++i) {
				if (i > 0)
					builder.append(", ");
				builder.append(arguments.get(i));
			}			
		}
		builder.append("):");
		builder.append(returnTypeFqn);
		return builder.toString();
	}
	@Override
	public String getCaption() {
		return "Invocations";
	}
	
}
