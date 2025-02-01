package christmas.discount;

import christmas.domain.Order;
import christmas.domain.dto.DiscountResult;
import christmas.domain.food.Food;

public abstract class Discount {

    protected String discountName;

    public Discount(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountName() {
        return this.discountName;
    }

    public abstract void applyDiscount(Order order);

    public abstract Boolean checking(Order order);

}
