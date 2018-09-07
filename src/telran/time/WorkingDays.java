package telran.time;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class WorkingDays implements TemporalAdjuster {

	DayOfWeek[] weekend;
	int 		i;
	int 		numberOfWorkingDaysAWeek;
	
	public WorkingDays(int i, DayOfWeek[] weekend) {
		this.i 							= i;
		this.weekend 					= weekend;
		this.numberOfWorkingDaysAWeek	= 7 - weekend.length;
	}

	@Override
	public Temporal adjustInto(Temporal temporal) {
		int numberOfWeeks 	= i / numberOfWorkingDaysAWeek;
		int numberOfDays	= i % numberOfWorkingDaysAWeek;
		temporal 			= temporal.plus(numberOfWeeks, ChronoUnit.WEEKS);
		
		int j = 0;
		while(j < numberOfDays) {
			temporal = temporal.plus(1, ChronoUnit.DAYS);
			if (!findDayInArray(weekend, DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)))) {
				j++;
			}
		}
		return temporal;
	}

	private boolean findDayInArray(DayOfWeek[] a, DayOfWeek key) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(key)) {
				return true;
			}
		}
		return false;
	}
}
