import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
	Earthquake1 E1 = new Earthquake1();
	Earthquake2 E2 = new Earthquake2();
	LinkedList<Double> noData = new LinkedList<Double>();
	LinkedList<Double> threeDates = new LinkedList<Double>();  
	LinkedList<Double> threeDates2 = new LinkedList<Double>();  
	LinkedList<Double> threeDates3= new LinkedList<Double>();  
	LinkedList<Double> threeDates4= new LinkedList<Double>(); 
	LinkedList<Double> threeDates5= new LinkedList<Double>(); 
	LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> Nov2Reports = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> Nov3Reports = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> Nov4Reports = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> Nov5Reports = new LinkedList<MaxHzReport>();

	public EarthquakeExamples() { }
	
	//tests one report for a month
	@Test
	public void instructorTestEQ() { 

		threeDates.add(20151013.0);
		threeDates.add(10.0);
		threeDates.add(5.0);
		threeDates.add(20151020.0);
		threeDates.add(40.0);
		threeDates.add(50.0);
		threeDates.add(45.0);
		threeDates.add(20151101.0);
		threeDates.add(6.0);
		NovReports.add(new MaxHzReport(20151101.0, 6.0));

		assertEquals(NovReports, 
				E1.dailyMaxForMonth(threeDates, 11));
	}
	
	//tests multiple reports for a month (nov in this case)
	@Test
	public void testMonthReport1() { 
		threeDates2.add(20151013.0);
		threeDates2.add(10.0);
		threeDates2.add(5.0);
		threeDates2.add(20151020.0);
		threeDates2.add(40.0);
		threeDates2.add(50.0);
		threeDates2.add(45.0);
		threeDates2.add(20151101.0);
		threeDates2.add(6.0);
		threeDates2.add(7.0);
		threeDates2.add(20151102.0);
		threeDates2.add(7.0);
		Nov2Reports.add(new MaxHzReport(20151101.0, 7.0));
		Nov2Reports.add(new MaxHzReport(20151102.0, 7.0));

		assertEquals(Nov2Reports, 
				E1.dailyMaxForMonth(threeDates2, 11));
	}
	
	//again test multiple reports for a month (oct in this case)
	@Test
	public void monthReportTest2() { 
		threeDates3.add(20151013.0);
		threeDates3.add(10.0);
		threeDates3.add(5.0);
		threeDates3.add(20151020.0);
		threeDates3.add(40.0);
		threeDates3.add(50.0);
		threeDates3.add(20151101.0);
		threeDates3.add(6.0);
		threeDates3.add(7.0);
		threeDates3.add(20151102.0);
		threeDates3.add(7.0);
		Nov3Reports.add(new MaxHzReport(20151013.0, 10.0));
		Nov3Reports.add(new MaxHzReport(20151020.0, 50.0));

		assertEquals(Nov3Reports, 
				E1.dailyMaxForMonth(threeDates3, 10));
	}

	///tests for an empty list of reports when you enter a month that doesn't exist
	@Test
	public void monthDNETest() { 
		threeDates4.add(20151013.0);
		threeDates4.add(10.0);
		threeDates4.add(5.0);
		threeDates4.add(20151020.0);
		threeDates4.add(40.0);
		threeDates4.add(50.0);
		threeDates4.add(20151101.0);
		threeDates4.add(6.0);
		threeDates4.add(7.0);
		threeDates4.add(20151102.0);
		threeDates4.add(7.0);

		assertEquals(Nov4Reports, 
				E1.dailyMaxForMonth(threeDates4, 12));
	}
	
	//tests if you use an empty list of data
	@Test
	public void emptyListTest() { 
		assertEquals(Nov5Reports, 
				E1.dailyMaxForMonth(threeDates5, 12));
	}
}
//subtasks (basically the same for both versions)
//find the desired month by using the extractDate and isDate methods
//Once the desired month is found in the data, go through all the numbers before there is another date
//Save the greatest number before the next date as the max reading for that date
//create a MazHzReport with the date and max reading
//add the report with the desired month, and max reading for the month to the list of MaxHzReports
//loop through the rest of the data looking for the desired month and repeat
