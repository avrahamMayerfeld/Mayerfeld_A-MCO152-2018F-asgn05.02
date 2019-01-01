package electoralStrategies;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import base.ElecReportingBehavior;
import base.ElectionObserver;
import base.ReportingBehavior;
import election.ElectionObservable;

public class TooClose implements ElecReportingBehavior {

	@Override
	public LinkedHashMap<String, Integer> calculateVotes(LinkedHashMap<String, LinkedHashMap<String, Integer>> electionMap) {
		
		String stateName ="";
		int smallestDif = 0;
		for(Entry<String, LinkedHashMap<String, Integer>> state : electionMap.entrySet()) {
			int r = state.getValue().get("repelec");
		    int d = state.getValue().get("demelec");
		    if (d > r) {
		    	if(smallestDif == 0 ||d-r < smallestDif) {
		    		smallestDif = d-r;
		    		stateName = state.getKey();
		    	}
		    }
		}
		try {
			int r = electionMap.get(stateName).get("repelec");
			int d = electionMap.get(stateName).get("demelec");
		
			if (r < d) {
				int dif = d-r;
				if(dif %2 == 0) {
					r += (int)(dif/2);
					d -= (int)(dif/2);
				}
				else {
					dif -= 1;
					r += (int)(dif/2);
					d -= (int)(dif/2);
					r +=1;
				}
				electionMap.get(stateName).put("repelec", r);
				electionMap.get(stateName).put("demelec", d);
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return new HonestEle().calculateVotes(electionMap);
		
	}


}

/*	There is a second republican favoring strategy that considers the state where the democrat has the smallest
	lead to be "too close to call" and splitsthe electoral votes giving half to the democrat and half to the republica
	n (and in the event of an odd number it gives the extra vote to the republican of course)  */

