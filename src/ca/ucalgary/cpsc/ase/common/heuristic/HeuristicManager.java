package ca.ucalgary.cpsc.ase.common.heuristic;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.query.Query;

@Remote
public interface HeuristicManager {

	public Map<Integer, VotingResult> match(Query q) throws Exception;

	public List getMatchingItems(Integer id, Query q,
			String heuristic);

	public String getFullName(String heuristic);
		
}