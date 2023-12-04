package refactorChristmas;

@FunctionalInterface
public interface PromotionCondition {
    boolean isValidPromotion(Reservation reservation);
}
