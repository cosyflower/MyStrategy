package refactorChristmas.eventProfit;

import refactorChristmas.DiscountStatus;

public class TotalProfit extends EventProfit {
    // EnumMap + PromotionProfit
    public TotalProfit(DiscountStatus discountStatus, PromotionProfit promotionProfit) {
        super(discountStatus.getDiscountTotal() + promotionProfit.getPriceValue());
    }
}
