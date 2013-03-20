package ca.ucalgary.cpsc.ase.common.heuristic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VotingResult implements Serializable {

	private static final long serialVersionUID = 9178557905916724125L;

	private Integer id;
	private Integer rank;
	private Double score;
	private String fqn;
	private Map<String, ResultItem> heuristics;
	
	public VotingResult(Integer id, String fqn) {
		this.id = id;
		this.fqn = fqn;
		this.rank = null;
		this.score = new Double(0);
		this.heuristics = new HashMap<String, ResultItem>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFqn() {
		return fqn;
	}

	public void setFqn(String fqn) {
		this.fqn = fqn;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getScore() {
		return score;
	}
	
	public Set<String> getHeuristics() {
		return heuristics.keySet();
	}
	
	public Double getScore(String heuristic) {
		return heuristics.get(heuristic).getScore();
	}
	
	public double add(Heuristic heuristic, ResultItem item) {
		heuristics.put(heuristic.getName(), item);
		score += item.getScore();
		return score;
	}
	
}
