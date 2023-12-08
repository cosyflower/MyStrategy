package refactorChristmas.promotion;

public class PromotionPlanner {
    // Reservation 과 협력한다
    // Reservation을 확인하고 120000원을 넘으면 Promotion을 전달한다
    private final Promotion promotion;

    public PromotionPlanner(Promotion promotion) {
        this.promotion = promotion;
    }

    public Promotion deliverPromotion() {
        return promotion;
    }
}
