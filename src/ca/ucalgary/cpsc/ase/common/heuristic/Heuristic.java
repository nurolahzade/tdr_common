package ca.ucalgary.cpsc.ase.common.heuristic;

import java.util.List;
import java.util.Map;

import ca.ucalgary.cpsc.ase.common.query.Query;

public interface Heuristic {

	public static final String UNKNOWN = "UNKNOWNP.UNKNOWN";
	public static final String UNKNOWN_PACKAGE = "UNKNOWNP.";

	public Map<Integer, ResultItem> match(Query q) throws Exception;
	public List<String> getMatchingItems(Integer id, Query q);
	public String getName();
	public String getFullName();
}
