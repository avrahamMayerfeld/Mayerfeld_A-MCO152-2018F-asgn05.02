package electoralStrategies;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import base.ElecReportingBehavior;
import base.ElectionObserver;
import base.ReportingBehavior;
import election.ElectionObservable;

public class TexasAlwaysR implements ElecReportingBehavior {

	@Override
	public LinkedHashMap<String, Integer> calculateVotes(LinkedHashMap<String, LinkedHashMap<String, Integer>> electionMap) {
		
		LinkedHashMap<String, Integer> texas = electionMap.get("texas");
		int r = texas.get("repelec");
		int d = texas.get("demelec");
		
		if (r < d) {
			int dif = d-r;
			r += (int)(dif/2);
			d -= (int)(dif/2);
			r+=2;
			d-=2;
			
			texas.put("repelec", r);
			texas.put("demelec", d);
			electionMap.put("texas", texas);
			}
		
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
