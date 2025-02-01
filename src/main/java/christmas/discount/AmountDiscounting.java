package christmas.discount;

import christmas.domain.Order;

public abstract class AmountDiscounting extends Discount{

    protected int discountAmount;

    public AmountDiscounting(String discountName) {
        super(discountName);
    }

    @Override
    public String getDiscountName() {
        return super.getDiscountName();
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }

    @Override
    public void applyDiscount(Order order) {
        if (checking(order)) {
            this.discountAmount = applyAmountDiscount(order);
            order.getDiscountList().add(this);
        }
    }

    public abstract int applyAmountDiscount(Order order);

    public abstract Boolean checking(Order order);
}
