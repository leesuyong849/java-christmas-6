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
    //적용된 할인의 할인금액을 저장하고 order에 어떤 할인이 적용되었는지 저장한다.
    public void applyDiscount(Order order) {
        if (checking(order)) {
            this.discountAmount = applyAmountDiscount(order);
            order.addAmountDiscount(this);
        }
    }

    //얼마나 할인할지 계산한다.
    public abstract int applyAmountDiscount(Order order);

    //할인을 적용할지 판단한다.
    public abstract Boolean checking(Order order);
}
