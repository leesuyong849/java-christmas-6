package christmas.domain.dto;

import christmas.domain.food.Food;

public class DiscountResult {

    private int discountingPrice;
    private Food giftingFood;

    public DiscountResult(int discountingPrice, Food giftingFood) {
        this.discountingPrice = discountingPrice;
        this.giftingFood = giftingFood;
    }

    public int getDiscountingPrice() {
        return discountingPrice;
    }

    public Food getGiftingFood() {
        return giftingFood;
    }
}
