package electoralStrategies;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import base.ElecReportingBehavior;
import base.ElectionObserver;

import election.ElectionObservable;

public class HonestEle implements ElecReportingBehavior {
	
	@Override
	public String calculateWinner(
			LinkedHashMap<String, LinkedHashMap<String, Integer>> popElectionMap,
			LinkedHashMap<String, Integer> elecElectionMap) 
	{
		int elecDemVotesTtl =0;
		int elecRepubVotesTtl=0;

		for(Entry<String, LinkedHashMap<String, Integer>> state : popElectionMap.entrySet())
		{
			LinkedHashMap<String, Integer> parties = state.getValue();

			if(parties.get("dempop") > parties.get("reppop"))
				elecDemVotesTtl += elecElectionMap.get(state.getKey());
			else if(parties.get("dempop") < parties.get("reppop"))	
				elecRepubVotesTtl += elecElectionMap.get(state.getKey());
			else if(parties.get("dempop") == parties.get("reppop"))	
			{
				int half = elecElectionMap.get(state.getKey()) /2;
				elecDemVotesTtl += half;
				elecRepubVotesTtl += half;
			}
		}		

		//return winner	
		String party = " ";
		if(elecDemVotesTtl > elecRepubVotesTtl)
			party = "the Democrat candidate.";
		else if(elecDemVotesTtl < elecRepubVotesTtl)
			party = "the Republican candidate.";
		else
			party = ("too close to call.");

		return party;
	}

}


