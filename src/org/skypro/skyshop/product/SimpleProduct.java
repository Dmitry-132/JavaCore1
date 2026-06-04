package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final double productPrice;

    public SimpleProduct(String productName, double productPrice) throws IllegalArgumentException {
        super(productName);
        if (productPrice < 1) {
            throw new IllegalArgumentException("Цена продукта должна быть выше или ровна 1");
        }
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
