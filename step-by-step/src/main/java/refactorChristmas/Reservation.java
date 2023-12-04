package refactorChristmas;

public class Reservation {
    private final ReservationDate reservationDate;
    private final ReservationOrders reservationOrders;

    public Reservation(ReservationDate reservationDate, ReservationOrders reservationOrders) {
        this.reservationDate = reservationDate;
        this.reservationOrders = reservationOrders;
    }

    public boolean isWeekDay() {
        return reservationDate.isWeekDayValue();
    }

    public boolean isWeekend() {
        return reservationDate.isWeekendValue();
    }

    public boolean isBeforeOrChristmasDay() {
        return reservationDate.isBeforeChristmasValue();
    }

    public boolean isSpecialDay() {
        return reservationDate.isSpecialDayValue();
    }
}
