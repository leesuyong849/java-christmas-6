package christmas.discount;

import christmas.domain.Order;
import christmas.domain.dto.DiscountResult;
import christmas.domain.food.Food;
import christmas.domain.food.Main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class WeekendDiscount implements Discount{

    private final int DISCOUNT_NUM = 2023;

    @Override
    public Integer Discounting(Order order) {
        Map<Food, Integer> menu = order.getMenu();
        int count = 0;
        for (Food s : menu.keySet()) {
            if (s.getClass() == Main.class) {
                count++;
            }
        }
        return DISCOUNT_NUM * count;
    }

    @Override
    public Food gifting(Order order) {
        return null;
    }

    @Override
    public String getDiscountName() {
        return "주말 할인";
    }

    @Override
    public Boolean checking(Order order) {
        Integer date = order.getDate();
        LocalDate localDate = LocalDate.of(2023, 12, date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return true;
        }

        return false;
    }

    @Override
    public DiscountResult discountResult(Order order) {
        return Discount.super.discountResult(order);
    }
}
