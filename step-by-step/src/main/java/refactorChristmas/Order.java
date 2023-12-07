package refactorChristmas;

public class Order {
    private final Menu menu; // 메뉴 관련 정보
    private final MenuQuantity menuQuantity; // 수량

    public Order(Menu menu, MenuQuantity menuQuantity) {
        this.menu = menu;
        this.menuQuantity = menuQuantity;
    }

    public boolean isMainType() {
        return menu.getMenuType() == MenuType.MAIN;
    }

    public boolean isDesertType() {
        return menu.getMenuType() == MenuType.DESERT;
    }
}
