package refactorChristmas;

import java.util.List;

public class ReservationOrders {
    private final List<Order> reservationOrders; // 90분 소요

    public ReservationOrders(List<Order> reservationOrders) {
        this.reservationOrders = reservationOrders;
    }

    public int getDesertTotal() {
        return 0;
    }

    public int getMainTotal() {
        return 0;
    }
}
