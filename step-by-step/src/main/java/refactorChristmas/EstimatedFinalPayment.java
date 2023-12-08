package refactorChristmas;

import refactorChristmas.eventProfit.EventProfit;
import refactorChristmas.reservation.Reservation;

public class EstimatedFinalPayment extends EventProfit {
    public EstimatedFinalPayment(Reservation reservation, DiscountStatus discountStatus) {
        super(reservation.getOrderPriceTotal() - discountStatus.getDiscountTotal());
    }
}
