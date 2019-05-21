package electoralStrategies;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import base.ElecReportingBehavior;

/* considers the state where the democrat has the smallest
	lead to be "too close to call" and splits the electoral votes giving half to the democrat and half to the republica
	n. Extra vote goes to republican.*/
public class TooClose implements ElecReportingBehavior{
@Override
	public String calculateWinner(LinkedHashMap<String, LinkedHashMap<String, Integer>> popElectionMap,
			LinkedHashMap<String, Integer> elecElectionMap) {
		int elecDemVotesTtl = 0;
		int elecRepubVotesTtl= 0;
		String minStateName = "";
		int minLead = 0;
		for(Entry<String, LinkedHashMap<String, Integer>> state : popElectionMap.entrySet())
		{   
			int dif = state.getValue().get("dempop") - state.getValue().get("reppop");
			if(dif > 0 && (minLead == 0 || dif < minLead))
			{
				minLead = dif;
				minStateName = state.getKey();
			}
		}


		for(Entry<String, LinkedHashMap<String, Integer>> state : popElectionMap.entrySet())
		{

			if(state.getKey().equals(minStateName))
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
			else 
			{	
				LinkedHashMap<String, Integer> parties = state.getValue();
				if(parties.get("dempop") > parties.get("reppop"))
					elecDemVotesTtl += elecElectionMap.get(state.getKey());
				else if(parties.get("dempop") < parties.get("reppop"))	
					elecRepubVotesTtl += elecElectionMap.get(state.getKey());
				else if(parties.get("dempop") == parties.get("reppop"))	
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

