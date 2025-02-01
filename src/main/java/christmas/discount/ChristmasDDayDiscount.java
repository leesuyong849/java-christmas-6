package christmas.discount;

import christmas.domain.Order;

public class ChristmasDDayDiscount extends AmountDiscounting {

    public ChristmasDDayDiscount() {
        super("크리스마스 디데이 할인");
    }

    @Override
    public String getDiscountName() {
        return super.getDiscountName();
    }

    @Override
    public Boolean checking(Order order) {
        if (order.getDate() <= 25) {
            return true;
        }
        return false;
    }

    @Override
    public int applyAmountDiscount(Order order) {
        return 1000 + (order.getDate() - 1) * 100;
    }
}
