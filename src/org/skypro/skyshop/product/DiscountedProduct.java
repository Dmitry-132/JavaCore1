package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int discountInWholePercentages;
    private double basePrice;

    public DiscountedProduct(String productName, double basePrice, int discountInWholePercentages) {
        super(productName,basePrice);
        this.discountInWholePercentages = discountInWholePercentages;
    }

@Override
    public double getProductPrice() {
        return productPrice - ((productPrice * discountInWholePercentages) / 100);
    }

    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        double finalPrice = getProductPrice();
        System.out.printf("%s : %.2f (%d %%)%n", productName, finalPrice,discountInWholePercentages);
        return null;
    }
}
