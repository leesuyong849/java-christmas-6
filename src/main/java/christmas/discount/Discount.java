package christmas.discount;

import christmas.domain.Order;
import christmas.domain.dto.DiscountResult;
import christmas.domain.food.Food;

public interface Discount {

    Integer Discounting(Order order);
    Food gifting(Order order);
    String getDiscountName();

    Boolean checking(Order order);

    default DiscountResult discountResult(Order order) {
        if (checking(order)) {
            return new DiscountResult(Discounting(order), gifting(order));
        }
        return null;
    }
}
