package refactorChristmas;

import java.util.List;

public class ReservationOrders {
    private final List<Order> reservationOrders; // 90분 소요

    public ReservationOrders(List<Order> reservationOrders) {
        this.reservationOrders = reservationOrders;
    }

    public int getDesertTotal() {
        return (int) reservationOrders.stream()
                .filter(Order::isDesertType)
                .count();
    }

    public int getMainTotal() {
        return (int) reservationOrders.stream()
                .filter(Order::isMainType)
                .count();
    }
}
