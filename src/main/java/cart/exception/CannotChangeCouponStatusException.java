package cart.exception;

public class CannotChangeCouponStatusException extends IllegalArgumentException {

    public CannotChangeCouponStatusException() {
        super("사용하지 않은 쿠폰을 재발급 할 수 없습니다.");
    }
}
