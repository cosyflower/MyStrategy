package refactorChristmas.order;

import refactorChristmas.menu.Menu;
import refactorChristmas.menu.MenuQuantity;
import refactorChristmas.menu.MenuType;

public class Order {
    private final Menu menu; // 메뉴 관련 정보
    private final MenuQuantity menuQuantity; // 수량

    public Order(Menu menu, MenuQuantity menuQuantity) {
        this.menu = menu;
        this.menuQuantity = menuQuantity;
    }

    public boolean isSameType(MenuType menuType) {
        return menu.getMenuType() == menuType;
    }

    public int getMenuPrice() {
        return menu.getMenuPrice();
    }
}
