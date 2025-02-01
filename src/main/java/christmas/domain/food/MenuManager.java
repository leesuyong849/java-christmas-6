package christmas.domain.food;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private List<Food> foodList = new ArrayList<>();

    public MenuManager(List<Food> list) {
        this.foodList = list;
    }

    public void addMenuItem(Food item) {
        foodList.add(item);
    }

    public void printMenu() {
        for (Food food : foodList) {
            System.out.println(food.getName() + ": " + food.getPrice());
        }
    }

    public int findPriceByName(String name) {
        for (Food food : foodList) {
            if (food.getName() == name) {
                return food.getPrice();
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
    }

    public Food findByName(String name) {
        for (Food food : foodList) {
            if (food.getName() == name) {
                return food;
            }
        }
        return null;
    }

    public Boolean hasFood(String name) {
        for (Food food : foodList) {
            if (food.getName() == name) {
                return true;
            }
        }
        return false;
    }
}
