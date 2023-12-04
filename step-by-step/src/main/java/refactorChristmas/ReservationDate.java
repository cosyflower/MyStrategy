package refactorChristmas;

import java.time.LocalDate;

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
}
