package christmas.domain;

import christmas.discount.AmountDiscounting;
import christmas.discount.Discount;
import christmas.discount.GiftDiscount;
import christmas.domain.food.Food;
import christmas.domain.food.MenuManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.service.Program.MENU;
import static christmas.validator.LogicValidator.validateFinalPrice;

public class Order {

    public final int BADGE1 = 5000;
    public final int BADGE2 = 100000;
    public final int BADGE3 = 200000;

    private Map<Food, Integer> menu;

    private final Integer originalPrice;

    private List<Discount> discountList;

    private Integer finalPrice;

    private Badge badge;

    private Integer date;

    public Order(Map<Food, Integer> menu, int date) {
        Integer inputedPrice = 0;

        this.date = date;
        this.menu = menu;

        for (Food food : menu.keySet()) {
            inputedPrice += food.getPrice();
        }

        this.originalPrice = inputedPrice;
        this.finalPrice = this.originalPrice;
        this.badge = null;
    }


//    public void calculateOrder() {
//        int discount = 0;
//        int originalPrice = 0;
//
//        //할인된 금액 모두 더하기
//        for (AmountDiscounting dis : amountDiscountingList) {
//            discount += dis.getDiscountAmount();
//        }
//
//        //증정품 있으면 찾아서 할인된 금액에 더하기
//        for (GiftDiscount gift : giftDiscountList) {
//            discount += MENU.findByName(gift.getGiftName()).getPrice();
//        }
//
//        //총 금액 계산
//        for (Food food : menu.keySet()) {
//            originalPrice += food.getPrice() * menu.get(food);
//        }
//
//        //뱃지 부여
//        if (this.originalPrice > BADGE1) {
//            badge = Badge.별;
//        } else if (this.originalPrice > BADGE2) {
//            badge = Badge.트리;
//        } else if (this.originalPrice > BADGE3) {
//            badge = Badge.산타;
//        }
//
//        this.finalPrice = originalPrice - discount;
//    }

    public Map<Food, Integer> getMenu() {
        return menu;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public List<Discount> getDiscountList() {
        return List.copyOf(discountList);
    }

    public List<AmountDiscounting> getAmountDiscountingList() {
        return List.copyOf(discountList.stream()
                .filter(discount -> discount instanceof AmountDiscounting)
                .map(discount -> (AmountDiscounting) discount)
                .collect(Collectors.toList()));
    }

    public List<GiftDiscount> getGiftDiscountList() {
        return List.copyOf(discountList.stream()
                .filter(discount -> discount instanceof GiftDiscount)
                .map(discount -> (GiftDiscount) discount)
                .collect(Collectors.toList()));
    }

    public void addAmountDiscount(AmountDiscounting discounting) {
        this.discountList.add(discounting);
        this.finalPrice = this.finalPrice - discounting.getDiscountAmount();

        validateFinalPrice(this.finalPrice);
    }

    public void addGiftDiscount(GiftDiscount discounting) {
        this.discountList.add(discounting);
        this.finalPrice = this.finalPrice - MENU.findPriceByName(discounting.getGiftName());

        validateFinalPrice(this.finalPrice);
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
