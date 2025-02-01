package christmas.domain.food;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private List<Food> foodList = new ArrayList<>();

    public void addMenuItem(Food item) {
        foodList.add(item);
    }

    public void printMenu() {
        for (Food food : foodList) {
            System.out.println(food.getName() + ": " + food.getPrice());
        }
    }
}
