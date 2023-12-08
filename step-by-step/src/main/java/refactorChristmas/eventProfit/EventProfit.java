package refactorChristmas.eventProfit;

public abstract class EventProfit {
    private final int priceValue;

    public EventProfit(int priceValue) {
        this.priceValue = priceValue;
    }

    public int getPriceValue() {
        return priceValue;
    }
}
