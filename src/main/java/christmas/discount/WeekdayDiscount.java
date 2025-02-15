package christmas.discount;

import christmas.domain.Order;
import christmas.domain.food.Dessert;
import christmas.domain.food.Food;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class WeekdayDiscount extends AmountDiscounting{

    private final int DISCOUNT_NUM = 2023;

    public WeekdayDiscount() {
        super("평일 할인");
    }


    @Override
    public int applyAmountDiscount(Order order) {
        Map<Food, Integer> menu = order.getMenu();
        int count = 0;
        for (Food s : menu.keySet()) {
            if (s.getClass() == Dessert.class) {
                count++;
            }
        }
        return DISCOUNT_NUM * count;
    }

    @Override
    public Boolean checking(Order order) {
        Integer date = order.getDate();
        LocalDate localDate = LocalDate.of(2023, 12, date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return false;
        }

        return true;
    }
}
