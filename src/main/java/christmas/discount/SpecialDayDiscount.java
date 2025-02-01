package christmas.discount;

import christmas.domain.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDayDiscount extends AmountDiscounting{

    public final int DISCOUNT_NUM = 1000;

    public SpecialDayDiscount(String discountName) {
        super("특별 할인");
    }

    @Override
    public int applyAmountDiscount(Order order) {
        return DISCOUNT_NUM;
    }

    @Override
    public Boolean checking(Order order) {
        Integer date = order.getDate();
        LocalDate localDate = LocalDate.of(2023, 12, date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SUNDAY || date == 25) {
            return true;
        }

        return false;
    }
}
