package cart.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class CouponResponse {

    @Schema(description = "쿠폰 아이디", example = "1")
    private final Long id;
    @Schema(description = "쿠폰 이름", example = "10000원 할인 쿠폰")
    private final String name;
    @Schema(description = "할인 금액", example = "10000")
    private final int discountAmount;
    @Schema(description = "설명", example = "오픈 기념 세일 쿠폰")
    private final String description;
    @Schema(description = "사용 유무", example = "false")
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
