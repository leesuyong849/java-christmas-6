package christmas.console;

import christmas.domain.Order;

import java.util.Map;

public class OutputView {

    private static void printOrderInfo(Order order) {
        System.out.println("\n12월 " + order.getDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");

        int totalPrice = 0;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            int price = MENU_PRICES.get(item) * quantity;
            totalPrice += price;

            System.out.println(item + " " + quantity + "개");
        }

        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(totalPrice + "원\n");

        System.out.println("<증정 메뉴>");
        System.out.println("없음\n");

        System.out.println("<혜택 내역>");
        System.out.println("없음\n");

        System.out.println("<총혜택 금액>");
        System.out.println("0원\n");

        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(totalPrice + "원\n");

        System.out.println("<12월 이벤트 배지>");
        System.out.println("없음\n");
    }
}
