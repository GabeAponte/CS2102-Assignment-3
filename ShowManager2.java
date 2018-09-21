/**
 * A class that holds the properties 
 * and methods for the ShowManager2 object
 * This class holds the second variation 
 * of the organizeShows method
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

class ShowManager2 {
	ShowManager2() {}
	
	/**
	 * This is the organizeShows method that consumes a linked list of show objects and
	 * and produces a ShowSummary (report) which contains a list of primetime and daytime shows
	 * from the original list 
	 * 
	 * @param shows  a linked list of show objects that will be sorted through
	 * @return report  a local ShowSummary object with a list of primetime and daytime shows
	 */
	public ShowSummary organizeShows(LinkedList <Show> shows){
		LinkedList <Show> daytime = new LinkedList <Show> ();
		LinkedList <Show> prime = new LinkedList <Show> ();
		LinkedList <Show> both = new LinkedList <Show> ();

		for (Show s : shows) {
			if(s.broadcastTime >= 600 && s.broadcastTime < 1700) {
				both.add(s);
			} else if (s.broadcastTime >= 1700 && s.broadcastTime < 2300) {
				both.add(s);
			}
		}

		for (Show s : both) {
			if(s.broadcastTime >= 600 && s.broadcastTime < 1700) {
				daytime.add(s);
			} else if (s.broadcastTime >= 1700 && s.broadcastTime < 2300) {
				prime.add(s);
			}
		}

		ShowSummary report = new ShowSummary (daytime, prime);
		return report;
	}
}
