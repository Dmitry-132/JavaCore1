package org.skypro.skyshop.product;

public abstract class Product {
    protected final String productName;
    protected final double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        if (productPrice <= 0) {
            throw new IllegalArgumentException(" Стоимость товара не может иметь отрицательное или нулевое значение");
        } else {
            this.productPrice = productPrice;
        }
    }

    public String getProductName() {
        return productName;
    }

    public abstract boolean isSpecial();
    public abstract double getProductPrice();
}
