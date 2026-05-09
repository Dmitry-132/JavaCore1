package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private double productPrice;

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

    public double getProductPrice() {
        return productPrice;
    }
}
