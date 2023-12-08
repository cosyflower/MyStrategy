package refactorChristmas.promotion;

import refactorChristmas.eventProfit.PromotionProfit;
import refactorChristmas.menu.Menu;

public class Promotion {
    private final Menu promotionMenu; // 이름, 그리고 가격 정보를 모두 포함하고 있음
    private final PromotionProfit promotionProfit; // 프로모션 증정 금액

    public Promotion(Menu promotionMenu) {
        this.promotionMenu = promotionMenu;
        this.promotionProfit = new PromotionProfit(promotionMenu.getMenuPrice());
    }

    public Menu getPromotionMenu() {
        return promotionMenu;
    }

    public PromotionProfit getPromotionProfit() {
        return promotionProfit;
    }

    public int getPromotionPriceValue() {
        return promotionProfit.getPriceValue();
    }
}
