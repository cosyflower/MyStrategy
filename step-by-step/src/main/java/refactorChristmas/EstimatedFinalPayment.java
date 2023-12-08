package refactorChristmas;

import refactorChristmas.eventProfit.EventProfit;

public class EstimatedFinalPayment extends EventProfit {
    public EstimatedFinalPayment(int totalWithoutDiscount, DiscountStatus discountStatus) {
        // 할인 전 총 주문 금액, 그리고 할인 내역이 필요하다
        super(totalWithoutDiscount - discountStatus.getDiscountTotal());
    }
}
