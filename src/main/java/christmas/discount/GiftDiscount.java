package christmas.discount;

import christmas.domain.Order;

public abstract class GiftDiscount extends Discount{

    protected String gift;

    public GiftDiscount(String discountName) {
        super(discountName);
    }

    @Override
    public String getDiscountName() {
        return super.getDiscountName();
    }

    public String getGiftName() {
        return this.gift;
    }

    @Override
    public void applyDiscount(Order order) {
        if (checking(order)) {
            this.gift = applyGiftDiscount(order);
            order.getDiscountList().add(this);
        }
    }

    public abstract String applyGiftDiscount(Order order);

    public abstract Boolean checking(Order order);


}
