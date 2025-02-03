package christmas.service;

import christmas.discount.*;
import christmas.domain.Order;
import christmas.domain.food.*;

import java.io.Console;
import java.util.*;

import static christmas.console.InputView.inputDate;
import static christmas.console.InputView.inputOrder;
import static christmas.console.OutputView.printOrderInfo;

public class Program {

    public static final MenuManager MENU = new MenuManager(List.of(
            new Appetizer("양송이수프", 6000),
            new Appetizer("타파스", 5500),
            new Appetizer("시저샐러드", 8000),
            new Main("티본스테이크", 55000),
            new Main("바비큐립", 54000),
            new Main("해산물파스타", 35000),
            new Main("크리스마스파스타", 25000),
            new Dessert("초코케이크", 15000),
            new Dessert("아이스크림", 5000),
            new Drink("제로콜라", 3000),
            new Drink("레드와인", 60000),
            new Drink("샴페인", 25000)
    ));

    public void play() {
        Console console = System.console();

        //사용자로부터 입력 처리
        int date = inputDate(console);
        Map<String, Integer> orderList = inputOrder(console);

        //String으로 넘어온 메뉴를 FOOD 객체로 전환
        Map<Food, Integer> orderListFood = getFoodIntegerMap(orderList);

        Order order = new Order(orderListFood, date);

        DiscountService discountService  = new DiscountService();
        discountService.doDiscount(order);

        printOrderInfo(order);
    }

    private static Map<Food, Integer> getFoodIntegerMap(Map<String, Integer> orderList) {
        Map<Food, Integer> orderListFood = new HashMap<>();
        for (String s : orderList.keySet()) {
            Food food = MENU.findByName(s);
            orderListFood.put(food, orderList.get(s));
        }
        return orderListFood;
    }
}
