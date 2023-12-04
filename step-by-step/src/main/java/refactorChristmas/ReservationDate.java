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

    public boolean isBeforeChristmasValue() {
        return localDate.isBefore(LocalDate.of(2023, 12, 25)) ||
                localDate.isEqual(LocalDate.of(2023, 12, 25));
    }
}
