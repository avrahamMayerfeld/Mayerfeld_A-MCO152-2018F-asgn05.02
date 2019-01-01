package popularStrategies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import base.ElectionObserver;
import base.PopReportingBehavior;
import base.ReportingBehavior;
import election.ElectionObservable;

public class IgnoreRepubs implements PopReportingBehavior {

	@Override
	public LinkedHashMap<String, Integer> calculateVotes(LinkedHashMap<String, LinkedHashMap<String, Integer>> electionMap) {
		LinkedHashMap<String,Integer> total = new LinkedHashMap<String,Integer>();
		int demV = 0;
		int repV = 0;
		
		Entry<String, Integer> maxEntry = null;
		for(Entry<String,LinkedHashMap<String, Integer>> state : electionMap.entrySet()) {
			for(Entry<String,Integer> party : state.getValue().entrySet()) {
				if(party.getKey().contains("r")) {
				    if (maxEntry == null || party.getValue().compareTo(maxEntry.getValue()) > 0)
				    {
				        maxEntry = party;
				    }
				}
			}
		}
		//remove state with most republican votes(although this might not be a wise strategy, because there may also
		//be the most democrat votes and/or more democrat votes in this state)
		for(Entry<String,LinkedHashMap<String, Integer>> state: electionMap.entrySet()) {
			if (state.getValue().equals(maxEntry))
					electionMap.remove(state.getKey());
			break;
		}

		//return revised results
		for(Entry<String,LinkedHashMap<String, Integer>> state: electionMap.entrySet()) {
			for(Entry<String,Integer> party : state.getValue().entrySet()) {
				if(party.getKey().contains("r")) {
					repV += party.getValue();
				}
				if(party.getKey().contains("d")) {
					demV += party.getValue();
				}
			}
		}
		total.put("dem", demV);
		total.put("rep", repV);
		return total;
	}
	
}

	
	

