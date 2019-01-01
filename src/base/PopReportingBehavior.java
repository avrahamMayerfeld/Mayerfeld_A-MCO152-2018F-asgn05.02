public interface PopReportingBehavior  {
	//return map of vtotal votes for each state and party
	public LinkedHashMap<String,Integer> calculateVotes(LinkedHashMap<String,LinkedHashMap<String,Integer>> electionMap); 
}
