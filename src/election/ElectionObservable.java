package election;

import java.util.Observable;

import base.ElectionObserver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

	public class ElectionObservable extends Observable {
	
       
	  private  ArrayList<ElectionObserver> observers = new ArrayList<ElectionObserver>();
      private  LinkedHashMap <String,LinkedHashMap<String,Integer>> states = new LinkedHashMap<String,LinkedHashMap<String,Integer>>();
	   
	   State chicago = new State(0,0,0,"Chicago");
       State alabama = new State(0,0,0,"alabama");
       State newyork = new State(0,0,0,"newyork");
       State ohio = new State(0,0,0,"ohio");
       State texas = new State(0,0,0,"texas");
    
	   public void setAllVotes(int cpd,int cpr,int ce,int apd,int apr,int ae,int npd,
			   int npr,int ne,int opd,int opr,int oe,int tpd,int tpr,int te) {
		   chicago.setStateElection(cpd,cpr,ce);
	       alabama.setStateElection(apd,apr,ae);
	       newyork.setStateElection(npd,npr,ne);
	       ohio.setStateElection(opd,opr,oe);
	       texas.setStateElection(tpd,tpr,te);
	      
	       states.put("chicago", chicago.getVotes());
	       states.put("alabama",alabama.getVotes());
	       states.put("newyork",newyork.getVotes());
	       states.put("ohio",ohio.getVotes());
	       states.put("texas",texas.getVotes());
	       
	       notifyAllObservers();
	   }
	   
	
	   public  LinkedHashMap<String,LinkedHashMap<String,Integer>> getAllVotes() {
		   return states;
	 }

	   public void attach(ElectionObserver electionObserver){
		   observers.add(electionObserver);		
	   }

	   public void notifyAllObservers(){
		   for (ElectionObserver observer : observers) {
			   observer.update();
	      }
	   } 
}
