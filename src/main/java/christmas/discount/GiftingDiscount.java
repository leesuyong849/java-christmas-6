package christmas.discount;

import christmas.domain.Order;
import christmas.domain.dto.DiscountResult;
import christmas.domain.food.Food;

public class GiftingDiscount implements Discount{
    @Override
    public Integer Discounting(Order order) {
        return null;
    }

    @Override
    public Food gifting(Order order) {
        return null;
    }

    @Override
    public String getDiscountName() {
        return null;
    }

    @Override
    public Boolean checking(Order order) {
        if (order.getOriginalPrice() > 120000) {
            return true;
        }
        return false;
    }

    @Override
    public DiscountResult discountResult(Order order) {
        return Discount.super.discountResult(order);
    }
}
