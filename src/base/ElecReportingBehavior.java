public interface ElecReportingBehavior  {
	//return which party won each states electoral votes based on popular election
	public LinkedHashMap<String,String> calculateParties(LinkedHashMap<String,LinkedHashMap<String,Integer>> popElectionMap); 
}
