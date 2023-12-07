package refactorChristmas;


public class Order {
    private final Menu meun;
    private final MenuQuantity menuQuantity;

    public Order(Menu meun, MenuQuantity menuQuantity) {
        this.meun = meun;
        this.menuQuantity = menuQuantity;
    }
}
