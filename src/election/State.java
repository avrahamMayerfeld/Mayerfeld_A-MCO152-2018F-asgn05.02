package election;

import java.util.LinkedHashMap;
import java.util.Map;

public class State {
	  private int republicanPopVotes;
	  private int democratPopVotes;
	  private int elecVotes;
	  LinkedHashMap <String,Integer> votes; 
	  
	  private String statename;
	
	public State(int democratPopVotes, int republicanPopVotes, int electoralVotes, String statename) {
		this.statename = statename;
		votes = new LinkedHashMap<String,Integer>();
		setStateElection(democratPopVotes, republicanPopVotes, electoralVotes);
	}
	
	public void setStateElection(int democratPopVotes, int republicanPopVotes, int electoralVotes) {
		this.republicanPopVotes = republicanPopVotes;
		this.democratPopVotes = democratPopVotes;
		elecVotes = electoralVotes;
		votes.put("dempop", democratPopVotes);
		votes.put("reppop", republicanPopVotes);
		votes.put("elec", elecVotes);
	}
	public LinkedHashMap getVotes() {return votes;}
	public String getName() {return statename;}
}
