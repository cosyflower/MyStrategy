package refactorChristmas;

import java.util.function.Function;
import java.util.function.Predicate;

public enum Event {
    CRHISTMAS_DDAY_EVENT(Reservation::isBeforeOrChristmasDay,
            reservation -> new DiscountPrice(1000 + reservation.getDaysUntilChristmas())),
    WEEKDAY_EVENT(Reservation::isWeekDay,
            reservation -> new DiscountPrice(2023 * reservation.getDesertQuantity())), // 디저트 메뉴 개수
    WEEKEND_EVENT(Reservation::isWeekend,
            reservation -> new DiscountPrice(2023 * reservation.getMainQuantity())), // 메인 메뉴 개수 구하기
    SPECIAL_EVENT(Reservation::isSpecialDay,
            reservation -> new DiscountPrice(1000));
//    PROMOTION_EVENT(); // PromotionConditioner를 통해서 확인해야 한다 + 따로 명시하자

    private final Predicate<Reservation> reservationPredicate; // 할인여부 확인
    private final Function<Reservation, DiscountPrice> discountPriceFunction; // 할인 및 증정 금액을 제공한다

    Event(Predicate<Reservation> reservationPredicate,
          Function<Reservation, DiscountPrice> discountPriceFunction) {
        this.reservationPredicate = reservationPredicate;
        this.discountPriceFunction = discountPriceFunction;
    }

    public DiscountPrice checkDiscountEachEvent(Reservation reservation) {
        if (reservationPredicate.test(reservation)) {
            return discountPriceFunction.apply(reservation);
        }
        return new DiscountPrice(0);
    }
}
