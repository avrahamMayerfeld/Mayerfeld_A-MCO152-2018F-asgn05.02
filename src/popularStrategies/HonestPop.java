package popularStrategies;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import base.ElectionObserver;
import base.PopReportingBehavior;
import base.ReportingBehavior;
import election.ElectionObservable;
import electoralStrategies.HonestEle;

public class HonestPop implements PopReportingBehavior {

	@Override
	public LinkedHashMap<String, Integer> calculateVotes(LinkedHashMap<String, LinkedHashMap<String, Integer>> electionMap) {
		//reuse identical code from electoral honest strategy
		return new HonestEle().calculateVotes(electionMap);
	}

	
	

	

}
