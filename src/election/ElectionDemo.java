package election;

import base.ElectionObserver;
import observers.DemocratObserver;
import observers.DemocratRepublicanObserver;
import observers.HonestDemocratObserver;
import observers.HonestObserver;
import observers.RepublicanObserver;

public class ElectionDemo {
 
	public static void main(String[]args) {
		      ElectionObservable e2060 = new ElectionObservable();
              
		      ElectionObserver dem = new DemocratObserver(e2060);
		      ElectionObserver dr = new DemocratRepublicanObserver(e2060);
		      ElectionObserver hDem = new HonestDemocratObserver(e2060);
		      ElectionObserver h = new HonestObserver(e2060);
		      ElectionObserver rep = new RepublicanObserver(e2060);
	
		      System.out.println("First vote");
		      e2060.setAllVotes(10,10,20,20,10,10,20,20,10,10,20,20,10,10,20);
		      System.out.println();
		      
		      System.out.println("Second vote");
		      e2060.setAllVotes(10,10,10,10,10,10,10,10,10, 10, 10, 10, 10, 10, 10);
		      System.out.println();
		      
		      System.out.println("Third vote");
		      e2060.setAllVotes(20,10,20,10,20,10,10,10,20,20,10,10,20,20,10);
		
	}
}
