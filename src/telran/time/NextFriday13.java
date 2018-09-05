package telran.time;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextFriday13 implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		int delta = 13 - temporal.get(ChronoField.DAY_OF_MONTH);
		if (delta < 0) {
			temporal = temporal.plus(1, ChronoUnit.MONTHS);
		}
		temporal = temporal.plus(delta, ChronoUnit.DAYS);
		
		while (DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)) != DayOfWeek.FRIDAY) {
			temporal = temporal.plus(1, ChronoUnit.MONTHS);
		}
		return temporal;
	}
}
