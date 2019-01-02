package base;

import java.util.LinkedHashMap;

public interface ElecReportingBehavior  {
	//return which party won each states electoral votes based on popular election
	public String calculateWinner(LinkedHashMap<String,LinkedHashMap<String,Integer>> popElectionMap, 
			LinkedHashMap<String,Integer> elecElectionMap); 
}
