package org.skypro.skyshop.product;

public abstract class Product {
    protected final String productName;
//    protected final double productPrice;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract boolean isSpecial();

    public abstract double getProductPrice();
}
