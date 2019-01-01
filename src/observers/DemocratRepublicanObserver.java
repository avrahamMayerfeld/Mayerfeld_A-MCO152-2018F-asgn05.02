package observers;

import base.ElectionObserver;
import election.ElectionObservable;
import electoralStrategies.TexasAlwaysR;
import popularStrategies.IgnoreRepubs;

public class DemocratRepublicanObserver extends ElectionObserver{
//democrat popular, republican electoral
	public DemocratRepublicanObserver(ElectionObservable eo) {
		super(eo,new TexasAlwaysR(), new IgnoreRepubs(), "DemocratRepublicanObserver");
		// TODO Auto-generated constructor stub
	}

}
