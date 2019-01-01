package base;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import election.ElectionObservable;

import java.util.Observer;

/*this program uses pull, all election info is available to the observer update method, which we separate
  in order to feed those into the reporting strategies 
  within each observer. */
public abstract class ElectionObserver  {
	private PopReportingBehavior popStrategy;
	private ElecReportingBehavior elecStrategy;
	
    private ElectionObservable subject;
    //to process info from observable
    private LinkedHashMap<String,LinkedHashMap<String,Integer>> popVotes; 
    private LinkedHashMap<String,Integer> elecVotes; 
	//to process data from strategies
    private int popDemVotesTtl;
    private int popRepubVotesTtl;
    private int elecDemVotesTtl;
    private int elecRepubVotesTtl;
    
    private String observerName;
    
    public ElectionObserver(ElectionObservable eo, ElecReportingBehavior elec, PopReportingBehavior pop, String name){
		
		popStrategy = pop;
		elecStrategy = elec;
		popVotes = new LinkedHashMap<String,LinkedHashMap<String,Integer>>();
		elecVotes = new LinkedHashMap<String,Integer>();
		this.subject = eo;
		this.subject.attach(this);
		observerName = name;
	}
   //use each observer's strategies to modify the information from the election and display it
	public void update() {
	
		for(Entry<String, LinkedHashMap<String, Integer>> entry: subject.getAllVotes().entrySet())
		{
			String state = entry.getKey();
			LinkedHashMap<String,Integer> pop = new LinkedHashMap<String,Integer>();
		
			for(Entry<String,Integer> tally : entry.getValue().entrySet()) 
			{
			
				if(tally.getKey().contains("pop")) 
				{
					pop.put(tally.getKey(),tally.getValue());
				}
				else if(tally.getKey().contains("elec"))
				{
					elecVotes.put(state, tally.getValue());
			    }
			}
			popVotes.put(state, pop);
		}
		
		System.out.println(observerName + " results: ");
		System.out.println("Expected popular vote winner: " + popularReport());
		System.out.println("Expected Electoral college winner:" + electoralReport());
    	legalmsg();
	}

	//place dem and repub totals returned in reporting behavior maps in the four fields in the observer to get the winning candidate
	
	private String popularReport() {
		String party = "";
  		//calculate votes
  		 popDemVotesTtl = popStrategy.calculateVotes(popVotes).get("dem");
  		 popRepubVotesTtl = popStrategy.calculateVotes(popVotes).get("rep");
		 //return winner		
	  	if(popDemVotesTtl > popRepubVotesTtl)
	  		party = "the Democrat candidate.";
	  	else if(popDemVotesTtl < popRepubVotesTtl)
	  		party = "the Republican candidate.";
	  	else
	  		party = ("too close to call.");
	  	return party;
 
	}
	private String electoralReport() {
		String party = "";
		//calculate votes
		//give all state votes to winner of popular vote.
	    for(Entry<String,String> state : elecStrategy.calculateParties(popVotes).entrySet()) {
	    	if(state.getValue().equals("democrat"))
	    		elecDemVotesTtl += elecVotes.get(state.getKey());
	    	else if(state.getValue().equals("republican"))
	    		elecRepubVotesTtl += elecVotes.get(state.getKey());
	    	else {
	    		int half = elecVotes.get(state.getKey()) /2;
	    		elecDemVotesTtl += half;
	    		elecRepubVotesTtl += half;
	    	}
	    }
	    
		//return winner		
		if(elecDemVotesTtl > elecRepubVotesTtl)
		  	party = "the Democrat candidate.";
		else if(elecDemVotesTtl < elecRepubVotesTtl)
		 	party = "the Republican candidate.";
	 	else
		  		party = ("too close to call.");
		return party;
	}

	public void legalmsg() {
		System.out.println(" All reports are purely observational and not legally binding in any way  "+new Date());
	}
	
}


