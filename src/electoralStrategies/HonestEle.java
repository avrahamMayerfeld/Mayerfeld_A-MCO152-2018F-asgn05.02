package electoralStrategies;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import base.ElecReportingBehavior;
import base.ElectionObserver;

import election.ElectionObservable;

public class HonestEle implements ElecReportingBehavior {
@Override
	public LinkedHashMap<String, String> calculateParties(LinkedHashMap<String, LinkedHashMap<String, Integer>> popElectionMap) {
		
		LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		for(Entry<String, LinkedHashMap<String, Integer>> state : popElectionMap.entrySet())
		{
			String winner = " ";
			LinkedHashMap<String, Integer> parties = state.getValue();
			
			if(parties.get("dempop") > parties.get("reppop"))
				winner = "democrat";
			else if(parties.get("dempop") < parties.get("reppop"))	
				winner = "republican";
			else if(parties.get("dempop") == parties.get("reppop"))	
			    winner = "none";
			states.put(state.getKey(), winner);
		}
		
		return states;
	}

}
