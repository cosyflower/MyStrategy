package refactorChristmas;

import java.util.function.Function;
import java.util.function.Predicate;
import refactorChristmas.eventProfit.DiscountProfit;
import refactorChristmas.eventProfit.EventProfit;
import refactorChristmas.reservation.Reservation;

public enum Event {
    CRHISTMAS_DDAY_EVENT(Reservation::isBeforeOrChristmasDay,
            reservation -> new DiscountProfit(1000 + reservation.getDaysUntilChristmas())),
    WEEKDAY_EVENT(Reservation::isWeekDay,
            reservation -> new DiscountProfit(2023 * reservation.getDesertQuantity())), // 디저트 메뉴 개수
    WEEKEND_EVENT(Reservation::isWeekend,
            reservation -> new DiscountProfit(2023 * reservation.getMainQuantity())), // 메인 메뉴 개수 구하기
    SPECIAL_EVENT(Reservation::isSpecialDay,
            reservation -> new DiscountProfit(1000));

    private final Predicate<Reservation> reservationPredicate; // 할인여부 확인
    private final Function<Reservation, DiscountProfit> discountPriceFunction; // 할인 및 증정 금액을 제공한다

    Event(Predicate<Reservation> reservationPredicate,
          Function<Reservation, DiscountProfit> discountPriceFunction) {
        this.reservationPredicate = reservationPredicate;
        this.discountPriceFunction = discountPriceFunction;
    }

    public DiscountProfit checkDiscountEachEvent(Reservation reservation) {
        if (reservationPredicate.test(reservation)) {
            return discountPriceFunction.apply(reservation);
        }
        return new DiscountProfit(0);
    }

    public static class EstimatedFinalPayment extends EventProfit {
        public EstimatedFinalPayment(int priceValue) {
            super(priceValue);
        }
    }
}
