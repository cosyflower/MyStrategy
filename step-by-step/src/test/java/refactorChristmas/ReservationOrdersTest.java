package refactorChristmas;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ReservationOrdersTest {
    @Test
    void flow() {
        ReservationOrders reservationOrders = new ReservationOrders(Arrays.asList(
                new Order(Menu.STEAK, new MenuQuantity(3)),
                new Order(Menu.STEAK, new MenuQuantity(1))
        ));

        int mainTotal = reservationOrders.getSpecificMenuTypeTotal(MenuType.MAIN);
        int desertTotal = reservationOrders.getSpecificMenuTypeTotal(MenuType.DESERT);

        System.out.println(mainTotal);
        System.out.println(desertTotal);
    }
}
