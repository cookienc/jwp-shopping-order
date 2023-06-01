package cart.controller.dto;

public class CouponResponse {

    private final Long id;
    private final String name;
    private final int discountAmount;
    private final String description;
    private final boolean isUsed;

    public CouponResponse(final Long id, final String name, final int discountAmount, final String description, final boolean isUsed) {
        this.id = id;
        this.name = name;
        this.discountAmount = discountAmount;
        this.description = description;
        this.isUsed = isUsed;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsUsed() {
        return isUsed;
    }
}
