/**
 * A class that holds the properties 
 * and methods for the ShowManager1 object
 * This class holds the first variation 
 * of the organizeShows method
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

class ShowManager1 {
	ShowManager1() {}
	
	/**
	 * This is the organizeShows method that consumes a linked list of show objects and
	 * and produces a ShowSummary (report) which contains a list of primetime and daytime shows
	 * from the original list 
	 * 
	 * @param shows  a linked list of show objects that will be sorted through
	 * @return report  a local ShowSummary object with a list of primetime and daytime shows
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows){
		ShowSummary report = new ShowSummary();

		for(Show s : shows) {
			if(s.broadcastTime >= 600 && s.broadcastTime < 1700) {
				report.daytime.add(s);
			} else if (s.broadcastTime >= 1700 && s.broadcastTime < 2300) {
				report.primetime.add(s);
			}
		}
		return report;
	}
}