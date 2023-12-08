package refactorChristmas.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReservationDate {
    private final LocalDate localDate;

    public ReservationDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public boolean isWeekDayValue() {
        return localDate.getDayOfWeek().getValue() >= 1 && localDate.getDayOfWeek().getValue() <= 5;
    }

    public boolean isWeekendValue() {
        return !isWeekDayValue();
    }

    public boolean isBeforeChristmasValue() {
        return localDate.isBefore(LocalDate.of(2023, 12, 25)) ||
                localDate.isEqual(LocalDate.of(2023, 12, 25));
    }

    public boolean isSpecialDayValue() {
        List<Integer> specialDayValues = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 25, 31));
        return specialDayValues.contains(localDate.getDayOfMonth());
    }

    public int getDayUnitlChristmasValue() {
        return 25 - localDate.getDayOfMonth();
    }
}
