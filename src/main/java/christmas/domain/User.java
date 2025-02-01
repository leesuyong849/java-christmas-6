package christmas.domain;

import java.util.List;

public class User {


    private String name;

    private List<Order> orders;

    private Integer totalDiscount;



    public User(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
        this.totalDiscount = 0;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
