package pageelements;

public class CouponInTable {

    private String couponName;
    private String couponCode;
    private String discount;

    public CouponInTable(String couponName, String couponCode, String discount) {
        this.couponName = couponName;
        this.couponCode = couponCode;
        this.discount = discount;
    }

    public String getDiscount() {
        return discount;
    }

}
