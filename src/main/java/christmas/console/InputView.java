package christmas.console;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import static christmas.service.Program.MENU;

public class InputView {

    public int inputDate(Console console) {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        while (true) {
            try {
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                String input = console.readLine().trim();
                int date = Integer.parseInt(input);

                if (date < 1 || date > 31) {
                    throw new IllegalArgumentException("[ERROR] 날짜는 1에서 31 사이의 숫자로 입력해야 합니다.");
                }
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 1~31 사이의 숫자를 입력해주세요.");
            }
        }
    }

    public static Map<String, Integer> inputOrder(Console console) {
        while (true) {
            try {
                System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
                String input = console.readLine().trim();
                return parseOrder(input);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 올바르지 않는 입력입니다.");
            }
        }
    }

    private static Map<String, Integer> parseOrder(String input) {
        Map<String, Integer> orderMap = new HashMap<>();
        String[] orders = input.split(",");
        int count = 0;

        for (String order : orders) {
            String[] parts = order.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("[ERROR] 올바른 주문 형식이 아닙니다. (예: 타파스-1)");
            }

            String itemName = parts[0].trim();
            int quantity;

            try {
                quantity = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 메뉴 개수는 숫자로 입력해야 합니다.");
            }

            if (!MENU.hasFood(itemName)) {
                throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다: " + itemName);
            }

            if (quantity < 1) {
                throw new IllegalArgumentException("[ERROR] 메뉴 개수는 1개 이상이어야 합니다.");
            }

            orderMap.put(itemName, orderMap.getOrDefault(itemName, 0) + quantity);
            count += quantity;
        }

        if (count > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴 개수는 최대 20개 입니다.");
        }
        return orderMap;
    }
}
