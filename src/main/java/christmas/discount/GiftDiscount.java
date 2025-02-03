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

    //계산된 할인을 적용하고 order에 해당 할인이 적용되었음을 저장한다.
    @Override
    public void applyDiscount(Order order) {
        if (checking(order)) {
            this.gift = applyGiftDiscount(order);
            order.addGiftDiscount(this);
        }
    }

    //상황에 맞는 할인을 계산한다.
    public abstract String applyGiftDiscount(Order order);

    //할인을 적용해야 하는 상황인지 판단한다.
    public abstract Boolean checking(Order order);


}
