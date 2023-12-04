package refactorChristmas;

import java.util.function.Predicate;
import java.util.function.Supplier;

public enum Event {
    CRHISTMAS_DDAY_EVENT(),
    WEEKDAY_EVENT(),
    WEEKEND_EVENT(),
    SPECIAL_EVENT(),
    ;
//    PROMOTION_EVENT(); // PromotionConditioner를 통해서 확인해야 한다 + 따로 명시하자

    private final Predicate<Reservation> reservationPredicate; // 할인여부 확인
    private final Supplier<DiscountPrice> discountPriceSupplier; // 할인 및 증정 금액을 제공한다

    Event(Predicate<Reservation> reservationPredicate,
          Supplier<DiscountPrice> discountPriceSupplier) {
        this.reservationPredicate = reservationPredicate;
        this.discountPriceSupplier = discountPriceSupplier;
    }
}
