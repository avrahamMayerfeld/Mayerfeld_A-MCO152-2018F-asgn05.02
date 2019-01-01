package observers;

import base.ElectionObserver;
import election.ElectionObservable;
import electoralStrategies.TooClose;
import popularStrategies.FiveLessDems;

public class RepublicanObserver extends ElectionObserver{

	public RepublicanObserver(ElectionObservable eo) {
		super(eo,new TooClose(), new FiveLessDems(), "RepublicanObserver");
		
	}

}
