package cart.domain.coupon;

public class Coupon {

    private static final Coupon EMPTY_COUPON = new Coupon(null, "empty", "empty", 1, true);

    private final Long id;
    private final Name name;
    private final Description description;
    private final DiscountAmount discountAmount;
    private final UsageStatus usageStatus;

    public Coupon(final Long id, final String name, final String description, final int discountAmount, final Boolean usageStatus) {
        this(id, Name.from(name), Description.from(description), DiscountAmount.from(discountAmount), UsageStatus.from(usageStatus));
    }

    public Coupon(final Long id, final Name name, final Description description, final DiscountAmount discountAmount, final UsageStatus usageStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discountAmount = discountAmount;
        this.usageStatus = usageStatus;
    }

    public static Coupon createCouponType(
            final Long id,
            final String name,
            final String description,
            final int discountAmount
    ) {
        return new Coupon(id, name, description, discountAmount, true);
    }

    public static Coupon empty() {
        return EMPTY_COUPON;
    }

    public boolean isUsed() {
        return usageStatus.getUsageStatus();
    }

    public boolean isNotUsed() {
        return usageStatus.isNotUsed();
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public DiscountAmount getDiscountAmount() {
        return discountAmount;
    }

    public UsageStatus getUsageStatus() {
        return usageStatus;
    }
}
