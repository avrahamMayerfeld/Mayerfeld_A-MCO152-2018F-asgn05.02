package popularStrategies;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import base.ElectionObserver;
import base.PopReportingBehavior;

import election.ElectionObservable;
import electoralStrategies.HonestEle;

public class HonestPop implements PopReportingBehavior {

	@Override
	public LinkedHashMap<String, Integer> calculateVotes(LinkedHashMap<String, LinkedHashMap<String, Integer>> electionMap) {
		LinkedHashMap<String,Integer> total = new LinkedHashMap<String,Integer>();
	    	int demV = 0;
		int repV = 0;
		
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
