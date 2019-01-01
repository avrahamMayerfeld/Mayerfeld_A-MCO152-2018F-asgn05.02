package observers;

import base.ElectionObserver;
import election.ElectionObservable;
import electoralStrategies.HonestEle;
import popularStrategies.HonestPop;

public class HonestObserver extends ElectionObserver{

	public HonestObserver(ElectionObservable eo) {
		super(eo,new HonestEle(), new HonestPop(), "HonestObserver");
		// TODO Auto-generated constructor stub
	}

}
