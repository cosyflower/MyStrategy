package refactorChristmas.menu;

import static refactorChristmas.menu.MenuType.MAIN;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Menu {
    STEAK(MAIN, "스테이크", 20_000),
    CHAMPAGNE(MenuType.DRINK, "샴페인", 25_000);

    private static final Map<String, Menu> menuMap = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(Menu::getMenuName, Function.identity()))
    );
    private final MenuType menuType;
    private final String MenuName;
    private final int menuPrice;

    Menu(MenuType menuType, String menuName, int menuPrice) {
        this.menuType = menuType;
        this.MenuName = menuName;
        this.menuPrice = menuPrice;
    }

    public static Menu findMenuByName(String menuName) {
        return Optional.ofNullable(menuMap.get(menuName))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 메뉴명입니다."));
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public String getMenuName() {
        return MenuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }
}
