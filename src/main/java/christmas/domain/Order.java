package christmas.domain;

import christmas.discount.Discount;
import christmas.domain.food.Food;

import java.util.List;
import java.util.Map;

public class Order {

    private User user;

    private Map<Food, Integer> menu;

    private Integer originalPrice;

    private List<Discount> discountList;

    private Integer finalPrice;

    private Badge badge;

    private Integer date;




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
        return finalPrice;
    }

    public String getBadge() {
        return badge.toString();
    }

    public Integer getDate() {
        return date;
    }
}
