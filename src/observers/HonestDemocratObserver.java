package observers;

import base.ElectionObserver;
import election.ElectionObservable;
import electoralStrategies.HonestEle;
import popularStrategies.IgnoreRepubs;

public class HonestDemocratObserver extends ElectionObserver{
//electoral honest, democrat popular
	public HonestDemocratObserver(ElectionObservable eo) {
		super(eo,new HonestEle(), new IgnoreRepubs(), "HonestDemocratObserver");
		// TODO Auto-generated constructor stub
	}

}
