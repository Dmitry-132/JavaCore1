package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final double productPrice;

    public SimpleProduct(String productName, double productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f ", productName, productPrice);
    }
}
