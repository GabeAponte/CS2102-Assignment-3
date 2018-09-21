/**
 * A class that holds the properties 
 * and methods for the DataSmooth1 object
 * This class holds the first variation 
 * of the DataSmooth method
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

class DataSmooth1 {
	DataSmooth1(){}

	/**
	 * the dataSmooth method consumes a list of shows and produces a 
	 * smoothed list of the shows' average runtimes
	 * 
	 * @param shows  a linkedlist of show objects
	 * @return smoothed  returns the local linkedlist of doubles that holds a smoothed list of the shows' average runtimes
	 */
	public LinkedList<Double> dataSmooth(LinkedList<Show> shows) {
		LinkedList<Double> smoothed = new LinkedList<Double> ();
		LinkedList<Double> avgtimes = new LinkedList<Double> ();

		//adds up the runtimes of the all the episodes of all the shows, and then divides the sum of all the runtimes
		//by the amount of episodes there are, then adds that value to the list 
		for (Show s : shows) {
			double avgRuntime = 0;
			for (Episode e : s.episodes) {
				avgRuntime = avgRuntime + e.runTime;
			}
			avgRuntime = avgRuntime/s.episodes.size();
			avgtimes.add(avgRuntime);
		}

		//takes the list of all the average run times and adds the smoothed data to another list
		for(int i = 0; i < avgtimes.size(); i++) {
			if (i== 0 || i == avgtimes.size()-1) {
				smoothed.add(avgtimes.get(i));
			} else {
				smoothed.add( (avgtimes.get(i-1) + avgtimes.get(i) + avgtimes.get(i+1))/3 );    
			}	
		}
		return smoothed;
	}
}