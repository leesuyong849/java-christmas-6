package christmas.domain;

public class DiscountRecord {

    private String name;

    private Integer discountedPrice;

    public DiscountRecord(String name, Integer discountedPrice) {
        this.discountedPrice = discountedPrice;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getDiscountedPrice() {
        return this.discountedPrice;
    }
}
