package refactorChristmas.eventProfit;

import refactorChristmas.DiscountStatus;
import refactorChristmas.promotion.PromotionProfit;

public class TotalProfit extends EventProfit {
    // EnumMap + PromotionProfit
    public TotalProfit(DiscountStatus discountStatus, PromotionProfit promotionProfit) {
        super(discountStatus.getDiscountTotal() + promotionProfit.getPriceValue());
    }
}
