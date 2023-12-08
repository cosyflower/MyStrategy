package refactorChristmas;

import refactorChristmas.reservation.Reservation;

public class EventPlanner {
    public void run() {
        setUp();

    }

    private void setUp() {
        Reservation reservation = new Reservation();
    }

    private void execute(Reservation reservation) {
        // 주문 메뉴 Reservation
        // 할인 전 총 주문 Reservation
        // 증정 메뉴 Event - Reservation
        // 혜택 내역 DiscountStatus 형성한다
        // 총 혜택 금액 - 형성된 DiscountStatus
        // 할인 후 예상 결제 금액 Reservation  - DiscountStatus
        // 배지 결과 (Estimated... - EventBadge)
    }

    private void terminate() {

    }
}
