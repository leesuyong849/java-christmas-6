package christmas.discount;

import christmas.domain.Order;
import christmas.domain.dto.DiscountResult;
import christmas.domain.food.Food;

public class ChristmasDDayDiscount implements Discount{
    @Override
    public String getDiscountName() {
        return "크리스마스 디데이 할인";
    }

    @Override
    public Boolean checking(Order order) {
        if (order.getDate() <= 25) {
            return true;
        }
        return false;
    }

    @Override
    public DiscountResult discountResult(Order order) {
        return Discount.super.discountResult(order);
    }


    @Override
    public Integer Discounting(Order order) {
        if (order.getDate() <= 25) {
            return 1000 + (order.getDate() - 1) * 100;
        }
        return 0;
    }

    @Override
    public Food gifting(Order order) {
        return null;
    }
}
