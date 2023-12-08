package refactorChristmas.eventProfit;

public class TotalProfit extends EventProfit {
    // 증정까지 포함한다
    // EnumMap + PromotionProfit
    public TotalProfit(int priceValue) {
        super(priceValue);
    }
}
