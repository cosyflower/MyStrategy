package refactorChristmas.order;

import java.util.List;
import refactorChristmas.menu.MenuType;

public class ReservationOrders {
    private final List<Order> reservationOrders; // 90분 소요

    public ReservationOrders(List<Order> reservationOrders) {
        this.reservationOrders = reservationOrders;
    }

    public int getSpecificMenuTypeTotal(MenuType menuType) {
        return (int) reservationOrders.stream()
                .filter(order -> order.isSameType(menuType))
                .count();
    }

    public boolean isOverPromotionCriteria() {
        return reservationOrders.stream()
                .mapToInt(Order::getMenuPrice)
                .sum() > 120_000;
    }
}
