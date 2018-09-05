package telran.time.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.time.NextFriday13;
import telran.time.WorkingDays;

class AdjusterTests {
	TemporalAdjuster nextFriday13;
	TemporalAdjuster workingDays;
	
	@BeforeEach
	void setUp() throws Exception {
		nextFriday13 	= new NextFriday13();
		workingDays 	= new WorkingDays
				(1, new DayOfWeek[] {DayOfWeek.FRIDAY, DayOfWeek.SATURDAY});
	}
	
	@Test
	void nextFriday13() {
		LocalDate expected = LocalDate.parse("2019-09-13");
		assertEquals(expected, LocalDate.of(2018, 9, 5).with(nextFriday13));
	}
	
	@Test
	void workingDays() {
		LocalDate expected = LocalDate.parse("2018-11-18");
		assertEquals(expected, LocalDate.of(2018, 11, 15).with(workingDays));
	}
}