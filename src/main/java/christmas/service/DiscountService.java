package christmas.service;

import christmas.discount.*;
import christmas.domain.Order;
import christmas.domain.food.Drink;
import christmas.domain.food.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DiscountService {

    private final int MIN_ORDER_PRICE = 10000;

    public static final List<Discount> discountList = Arrays.asList(
            new ChristmasDDayDiscount(),
            new GiftingDiscountInStarDay("샴페인"),
            new SpecialDayDiscount(),
            new WeekdayDiscount(),
            new WeekendDiscount()
    );

    public  void doDiscount(Order order) {

        if (isOverMinPrice(order.getOriginalPrice())){
            for (Discount discount : discountList) {
                discount.applyDiscount(order);
            }
        }
    }

    //최소 주문 금액 10000원 이상
    private  Boolean isOverMinPrice(Integer price) {
        if (price >= MIN_ORDER_PRICE) {
            return true;
        }
        return false;
    }
}
