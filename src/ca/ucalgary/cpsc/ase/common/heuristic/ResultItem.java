package ca.ucalgary.cpsc.ase.common.heuristic;


import java.io.Serializable;

import ca.ucalgary.cpsc.ase.common.entity.Clazz;

public class ResultItem implements Serializable {

	private static final long serialVersionUID = 1644419885972474873L;

	protected Clazz target;
	protected Double score;
	
	public Clazz getTarget() {
		return target;
	}
	
	public void setTarget(Clazz target) {
		this.target = target;
	}
	
	public Double getScore() {
		return score;
	}
	
	public void setScore(Double score) {
		this.score = score;
	}
			
}
