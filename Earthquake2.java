/**
 * A class that holds the properties 
 * and methods for the Earthquake2 object
 * This class holds the second variation 
 * of the dailyMaxForMonth method
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

class Earthquake2 {
	Earthquake2(){}

	/**
	 * This is the isDate method that consumes a double and produces a boolean value
	 * if that double is an 8 digit date
	 * 
	 * @param anum  a double that is to be check if it's a datnum
	 * @return true or false  a boolean value representing if a datnum is a date
	 */
	boolean isDate(double anum) { 
		return (int)anum > 10000000; 
	}
	
	/**
	 * This is the extractMonth method that consumes an 8 digit date and
	 * extracts the month
	 * 
	 * @param dateNum
	 * @return month  an int representing the month the date if from
	 */
	int extractMonth(double dateNum) { 
		return ((int)dateNum % 10000) / 100; 
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
	public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,int month) {
		LinkedList<MaxHzReport> listMaxReport = new LinkedList <MaxHzReport> ();
		double maxF = 0;

		for(int i = 0; i < data.size(); i++) {
			if(isDate(data.get(i))) {
				if(extractMonth(data.get(i)) == month) {
					for(int j = i+1; j < data.size() && !isDate(data.get(j)); j++) {
						if(data.get(j) > maxF) {
							maxF = data.get(j);
						}
					}
					MaxHzReport maxReport = new MaxHzReport (data.get(i), maxF);
					maxF = 0;
					listMaxReport.add(maxReport);
				}
			}
		}
		return listMaxReport;
	}
}