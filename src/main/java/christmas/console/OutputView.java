package christmas.console;

import christmas.domain.Order;

import java.util.Map;

public class OutputView {

    public static void printOrderInfo(Order order) {
        System.out.println("\n12월 " + order.getDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");


        System.out.println("<주문 메뉴>");
        order.getMenu().forEach((food, quantity) ->
                System.out.println(food.getName() + " " + quantity + "개"));

        System.out.println("\n<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", order.getOriginalPrice());

        System.out.println("\n<증정 메뉴>");
        order.getGiftDiscountList().forEach(discounting ->
                System.out.println(discounting.getGiftName() + " 1개"));

        System.out.println("\n<혜택 내역>");
        order.getAmountDiscountingList().forEach(discount ->
                System.out.printf("%s: -%,d원\n", discount.getDiscountName(), discount.getDiscountAmount()));

        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원\n", order.getDiscountedPrice());

        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", order.getFinalPrice());

        System.out.println("<12월 이벤트 배지>");
        System.out.printf("%s\n", order.getBadge());
    }
}
