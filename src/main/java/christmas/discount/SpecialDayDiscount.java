package christmas.discount;

import christmas.domain.Order;

public class SpecialDayDiscount implements Discount{

    private final int DISCOUNT_NUM = 1000;

    @Override
    public Integer Discounting(Order order) {
        return DISCOUNT_NUM;
    }

    @Override
    public String getDiscountName() {
        return null;
    }
}
