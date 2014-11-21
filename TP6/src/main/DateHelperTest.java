package main;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DateHelperTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getDateFromDate() throws ParseException {
		String date;
		date = DateHelper.getDateFromDate("2014-1-1");
		System.out.println(date);
		assertEquals("", "2014-01-01", date);

		date = DateHelper.getDateFromDate("2014-1-1 12:11");
		System.out.println(date);
		assertEquals("", "2014-01-01", date);
	}

	@Test
	public void getDateTimeFromDateTime() throws ParseException {
		String date;

		date = DateHelper.getDateTimeFromDateTime("2014-1-1 2:1");
		System.out.println(date);
		assertEquals("", "2014-01-01 02:01", date);
	}

	@Test
	public void getTimeFromDateTime() throws ParseException {
		String date;

		date = DateHelper.getTimeFromDateTime("2014-1-1 2:1:2");
		System.out.println(date);
		assertEquals("", "02:01", date);
	}
	@Test
	public void getTimeFromTime() throws ParseException {
		String date;

		date = DateHelper.getTimeFromTime("2:1:1");
		System.out.println(date);
		assertEquals("", "02:01", date);
	}
	
	

}
