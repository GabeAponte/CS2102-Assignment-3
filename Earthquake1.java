/**
 * A class that holds the properties 
 * and methods for the Earthquake1 object
 * This class holds the first variation 
 * of the dailyMaxForMonth method
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

class Earthquake1 {
	Earthquake1(){}

	/**
	 * This is the isDate method that consumes a double and produces a boolean value
	 * if that double is an 8 digit date
	 * 
	 * @param anum  a double that is to be check if it's a datnum
	 * @return true or false  a boolean value representing if a datnum is a date
	 */
	boolean isDate(double anum) {
		return (int) anum > 10000000; 
	}
	
	/**
	 * This is the extractMonth method that consumes an 8 digit date and
	 * extracts the month
	 * 
	 * @param dateNum
	 * @return month  an int representing the month the date if from
	 */
	int extractMonth(double dateNum) { 
		return ((int) dateNum % 10000) / 100; 
	}
	
	/**
	 * This is the dailtMaxForMonth function that consumes a linkedlist of doubles 
	 * and the number of a month and  produces a list of reports that indicate the highest 
	 * frequency reading for each day in that month
	 * 
	 * @param data  a linked list of doubles that represents the data to be checked
	 * @param month  an int representing the month you want the data to be found for
	 * @return reports  a local linked list of MazHzReport objects for the given month
	 */
	public LinkedList <MaxHzReport> dailyMaxForMonth (LinkedList<Double> data, int month) {
		LinkedList <MaxHzReport> reports = new LinkedList <MaxHzReport> (); 
		MaxHzReport maxReport = null;

		for(int i = 0; i < data.size(); i++) {
			if(isDate(data.get(i)) && extractMonth(data.get(i)) == month) {
				maxReport = new MaxHzReport(data.get(i), 0);
			} 

			if(!(isDate(data.get(i))) && !(maxReport == null) && data.get(i) > maxReport.maxReading) {
				maxReport.maxReading = data.get(i);
			}

			if (!(maxReport == null) && (i == data.size()-1 || isDate(data.get(i+1)))) {
				reports.add(maxReport);
				maxReport = null;
			}
		}
		return reports;	
	}
}


