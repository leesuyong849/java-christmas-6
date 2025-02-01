package christmas.domain;

import christmas.discount.AmountDiscounting;
import christmas.discount.Discount;
import christmas.discount.GiftDiscount;
import christmas.domain.food.Food;

import java.util.List;
import java.util.Map;

import static christmas.service.Program.MENU;

public class Order {

    private User user;

    private Map<Food, Integer> menu;

    private Integer originalPrice;

    private List<AmountDiscounting> amountDiscountingList;

    private List<GiftDiscount> giftDiscountList;

    private Integer finalPrice;

    private Badge badge;

    private Integer date;


    public void calculateOrder() {
        int discount = 0;
        int originalPrice = 0;
        Food giftedFood;

        //할인된 금액 모두 더하기
        for (AmountDiscounting dis : amountDiscountingList) {
            discount += dis.getDiscountAmount();
        }

        //증정품 있으면 찾아서 할인된 금액에 더하기
        for (GiftDiscount gift : giftDiscountList) {
            giftedFood = MENU.findByName(gift.getGiftName());
        }
        discount += giftedFood.getPrice();

        //총 금액 계산
        for (Food food : menu.keySet()) {
            originalPrice += food.getPrice() * menu.get(food);
        }

        //뱃지 부여


        this.originalPrice = originalPrice;
        this.finalPrice = originalPrice - discount;



    }

    public User getUser() {
        return user;
    }

    public Map<Food, Integer> getMenu() {
        return menu;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }


    public List<Discount> getDiscountList() {
        return discountList;
    }

    public Integer getDiscountedPrice() {
        return originalPrice - finalPrice;
    }

    public Integer getFinalPrice() {
        return this.finalPrice;
    }

    public String getBadge() {
        return badge.toString();
    }

    public Integer getDate() {
        return date;
    }
}
