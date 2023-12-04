package refactorChristmas;

public class Reservation {
    private final ReservationDate reservationDate;
    private final ReservationOrders reservationOrders;

    public Reservation(ReservationDate reservationDate, ReservationOrders reservationOrders) {
        this.reservationDate = reservationDate;
        this.reservationOrders = reservationOrders;
    }
}
