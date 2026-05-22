package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int discountInWholePercentages;
    private double basePrice;

    public DiscountedProduct(String productName, double basePrice, int discountInWholePercentages) {
        super(productName);
        this.basePrice = basePrice;
        this.discountInWholePercentages = discountInWholePercentages;
    }

    @Override
    public double getProductPrice() {
        return basePrice - ((basePrice * discountInWholePercentages) / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f (%d %%)", productName, getProductPrice(), discountInWholePercentages);
    }
}
