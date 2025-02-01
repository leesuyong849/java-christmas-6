package christmas.discount;

import christmas.domain.Order;

public class GiftingDiscountInStarDay extends GiftDiscount{

    public GiftingDiscountInStarDay(String giftName) {
        super("증정 이벤트");
        super.gift = giftName;
    }

    @Override
    public String applyGiftDiscount(Order order) {
        return super.gift;
    }

    @Override
    public Boolean checking(Order order) {
        if (order.getOriginalPrice() > 120000) {
            return true;
        }
        return false;
    }
}
