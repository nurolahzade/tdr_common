package ca.ucalgary.cpsc.ase.common.heuristic;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.query.Query;

@Remote
public interface HeuristicManager {

	public Map<Integer, VotingResult> match(Query q) throws Exception;
	
	public Map<Integer, VotingResult> match(Query q, Set<String> filter) throws Exception;

	public List getMatchingItems(Integer id, Query q,
			String heuristic);

	public String getFullName(String heuristic);

	public abstract Map<String, Set<String>> getMatchingDataFlows(Integer id, Query q)
			throws Exception;

	public Map<Integer, VotingResult> simulateInterfaceBasedRetrieval(
			Query query, String sut);
		
}
