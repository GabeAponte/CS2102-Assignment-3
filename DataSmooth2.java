/**
 * A class that holds the properties 
 * and methods for the DataSmooth2 object
 * This class holds the second variation 
 * of the DataSmooth method
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

class DataSmooth2 {
	DataSmooth2(){}
	
	/**
	 * This is the dataSmooth method that consumes a list of shows 
	 * and produces a smoothed list of the shows' average runtimes
	 * 
	 * @param shows a linkedlist of show objects
	 * @return smoothed  returns the local linkedlist of doubles that holds a smoothed list of the shows' average runtimes
	 */
	public LinkedList<Double> dataSmooth(LinkedList<Show> shows) {
		LinkedList<Double> smoothed = new LinkedList<Double> ();

		//adds up the runtimes of the all the episodes of all the shows, and then divides the sum of all the runtimes
		//by the amount of episodes there are, then sets the average length of the show to the avgRuntime
		for (Show s : shows) {
			double avgRuntime = 0;
			for (Episode e : s.episodes) {
				avgRuntime = avgRuntime + e.runTime;
			}

			avgRuntime = avgRuntime/s.episodes.size();
			s.setAvgLength(avgRuntime);
		}
		//takes the list of shows and compares it to the avgRuntimes and then adds the smoothed data to a new list
		for (int i = 0; i < shows.size(); i++) {
			if (i== 0 || i == shows.size()-1) {
				smoothed.add(shows.get(i).avgLength);
			} else {
				smoothed.add((shows.get(i-1).avgLength + shows.get(i).avgLength + shows.get(i+1).avgLength)/3);    
			}	
		}
		return smoothed;
	}
}