package christmas.domain;

import christmas.domain.food.Food;

import java.util.List;
import java.util.Map;

public class Order {

    private User user;

    private Map<Food, Integer> menu;

    private Integer originalPrice;

    private List<Food> giftFoodList;

    private List<DiscountRecord> discountRecordList;

    private Integer finalPrice;

    private Badge badge;

    private Integer date;

    public Order(User user, Map<Food, Integer> menu, Integer originalPrice,
                         List<Food> giftFoodList, List<DiscountRecord> discountRecordList,
                         Integer finalPrice, Badge badge, Integer date) {

        this.user = user;
        this.menu = menu;
        this.originalPrice = originalPrice;
        this.giftFoodList = giftFoodList;
        this.discountRecordList = discountRecordList;
        this.finalPrice = finalPrice;
        this.badge = badge;
        this.date = date;
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

    public List<Food> getGiftFoodList() {
        return giftFoodList;
    }

    public List<DiscountRecord> getDiscountRecordList() {
        return discountRecordList;
    }

    public Integer getDiscountedPrice() {
        return originalPrice - finalPrice;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public String getBadge() {
        return badge.toString();
    }

    public Integer getDate() {
        return date;
    }
}
