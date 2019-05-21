package electoralStrategies;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import base.ElecReportingBehavior;
import base.ElectionObserver;

import election.ElectionObservable;
//two percent of republican votes become democrat
public class TwoPercentRtoD implements ElecReportingBehavior {

	@Override
	public String calculateWinner(
			LinkedHashMap<String, LinkedHashMap<String, Integer>> popElectionMap,
			LinkedHashMap<String, Integer> elecElectionMap) 
	{
		int elecDemVotesTtl =0;
		int elecRepubVotesTtl=0;
	        LinkedHashMap<String, LinkedHashMap<String,Integer>> copy =  new LinkedHashMap<String, LinkedHashMap<String,Integer>>();
	        copy.putAll(popElectionMap);
		for(Entry<String, LinkedHashMap<String, Integer>> state : copy.entrySet())
		{
			LinkedHashMap<String, Integer> parties = state.getValue();
			int twoPercentR = (int) (parties.get("reppop") * .02);
			int newR = parties.get("reppop") - twoPercentR;
			int newD = parties.get("dempop") + twoPercentR;
					
					
			if(newD > newR)
				elecDemVotesTtl += elecElectionMap.get(state.getKey());
			else if(newD < newR)	
				elecRepubVotesTtl += elecElectionMap.get(state.getKey());
			else if(newD == newR)	
			{
				int half;
				if(elecElectionMap.get(state.getKey()) % 2 == 0)
			      	{
				    	half = elecElectionMap.get(state.getKey()) /2;
					elecDemVotesTtl += half;
					elecRepubVotesTtl += half;
				}
			   	else 
				{
					half = (elecElectionMap.get(state.getKey()) - 1) /2;
					elecDemVotesTtl += half;
					elecRepubVotesTtl += half + 1;
				}
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
		
		


