package refactorChristmas;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import refactorChristmas.eventProfit.DiscountProfit;
import refactorChristmas.eventProfit.EventProfit;

public class DiscountStatus {
    private final Map<Event, EventProfit> eventProfitMap;

    public DiscountStatus() {
        this.eventProfitMap = new EnumMap<Event, EventProfit>(Event.class);
        initMap();
    }

    private void initMap() {
        Arrays.stream(Event.values())
                .forEach(event -> eventProfitMap.put(event, new DiscountProfit(0)));
    }

    public void updateEventProfitStatus(Event event, EventProfit eventProfit) {
        eventProfitMap.replace(event, eventProfit);
    }

    public int getDiscountTotal() {
        return eventProfitMap.entrySet()
                .stream()
                .mapToInt(eventDiscountProfitEntry -> eventDiscountProfitEntry.getValue().getPriceValue())
                .sum();
    }
}
