package christmas.discount;

import christmas.domain.Order;

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
