package observers;

import java.util.Observable;

import base.ElecReportingBehavior;
import base.ElectionObserver;
import base.PopReportingBehavior;

import election.ElectionObservable;
import electoralStrategies.TwoPercentRtoD;
import popularStrategies.IgnoreRepubs;

public class DemocratObserver extends ElectionObserver {
	
     public DemocratObserver(ElectionObservable e) {
		super(e,new TwoPercentRtoD(),new IgnoreRepubs(),"DemocratObserver");
		// TODO Auto-generated constructor stub
	}
 
	
}
