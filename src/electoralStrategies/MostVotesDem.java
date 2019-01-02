package electoralStrategies;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import base.ElecReportingBehavior;
import base.ElectionObserver;

import election.ElectionObservable;

public class MostVotesDem implements ElecReportingBehavior {
	@Override
	public String calculateWinner(LinkedHashMap<String, LinkedHashMap<String, Integer>> popElectionMap,
			LinkedHashMap<String, Integer> elecElectionMap) {
		
		return null;
	}
	
		LinkedHashMap<String,Integer> total = new LinkedHashMap<String,Integer>();
		int demV = 0;
		int repV = 0;
		//state with most votes goes democrat 
		//find state with most votes
		LinkedHashMap<String,Integer> statesTotals = new LinkedHashMap<String,Integer>();
		for(Entry<String,LinkedHashMap<String, Integer>> state: electionMap.entrySet())
		{   int votes = 0;
		    
			for(Entry<String,Integer> party : state.getValue().entrySet()) 
			{
				votes += party.getValue();
			}
			statesTotals.put(state.getKey(), votes);
		}
		Entry<String, Integer> maxEntry = null;
		for(Entry<String, Integer> state: statesTotals.entrySet()) {
			if (maxEntry == null || state.getValue().compareTo(maxEntry.getValue()) > 0)
				{
					maxEntry = state;
				}
			}
		
		
		for(Entry<String,LinkedHashMap<String, Integer>> state: electionMap.entrySet()) {
			if(state.equals(maxEntry)) {
				LinkedHashMap<String,Integer> local = new LinkedHashMap<String,Integer>();
				for (Entry <String,Integer> party : state.getValue().entrySet()) 
					 local.put(party.getKey(),party.getValue());
				int r = local.get("repelec");
			    int d = local.get("demelec");
			  //change votes if necessary, not too drastically to avoid suspicion
				if (r > d) {
					int dif = r-d;
				r -= (int)(dif/2);
				d += (int)(dif/2);
				r-=2;
				d+=2;
				electionMap.get(state.getKey()).put("repelec", r);
				electionMap.get(state.getKey()).put("demelec", d);
				}
				//break to avoid changing more than one state if there are two with most votes amount
				break;
			}
		}
		
		//calcculate based on new map
		for(Entry<String,LinkedHashMap<String, Integer>> state: electionMap.entrySet()) {
			for(Entry<String,Integer> party : state.getValue().entrySet()) {
				if(party.getKey().contains("d")) {
					demV += party.getValue();
				}
				else if(party.getKey().contains("r")) {
					repV += party.getValue();
				}
			}
		}
		
		total.put("dem", demV);
		total.put("rep", repV);
		
		return total;
	}




	
	


}
