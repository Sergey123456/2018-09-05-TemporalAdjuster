package telran.time;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Arrays;

public class WorkingDays implements TemporalAdjuster {

	DayOfWeek[] dayOfWeeks;
	int i;
	
	public WorkingDays(int i, DayOfWeek[] dayOfWeeks) {
		this.i 			= i;
		this.dayOfWeeks = dayOfWeeks;
	}

	@Override
	public Temporal adjustInto(Temporal temporal) {
		for (int j = 0; j < i; j++) {
			temporal = temporal.plus(1, ChronoUnit.DAYS);
			if (Arrays.binarySearch(dayOfWeeks, DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK))) > -1) {
				j--;
			}
		}
		return temporal;
	}
}
