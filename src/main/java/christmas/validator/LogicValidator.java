package christmas.validator;

public class LogicValidator {

    public static void validateFinalPrice(Integer price) {
        if (price < 0) {
            throw new IllegalArgumentException("[ERROR] 할인된 금액에 문제가 발생했습니다.");
        }
    }
}
