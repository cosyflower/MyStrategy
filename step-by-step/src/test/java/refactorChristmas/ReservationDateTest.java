package refactorChristmas;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import refactorChristmas.reservation.ReservationDate;

public class ReservationDateTest {
    @Test
    void 크리스마스_전_혹은_크리스마스_당일인지_검증() {
        LocalDate christmasDay = LocalDate.of(2023, 12, 25);
        ReservationDate reservationDate = new ReservationDate(christmasDay);

        boolean beforeChristmasValue = reservationDate.isBeforeChristmasValue();
        System.out.println(beforeChristmasValue);
    }
}
