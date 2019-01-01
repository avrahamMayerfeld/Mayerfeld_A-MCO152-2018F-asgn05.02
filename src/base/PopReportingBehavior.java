package base;

import java.util.LinkedHashMap;

public interface PopReportingBehavior  {
	//return map of total votes for each state and party
	public LinkedHashMap<String,Integer> calculateVotes(LinkedHashMap<String,LinkedHashMap<String,Integer>> electionMap); 
}
