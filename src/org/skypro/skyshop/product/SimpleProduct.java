package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

    public SimpleProduct(String productName, double productPrice) {
        super(productName,productPrice);
    }

    public double getProductPrice() {
        return productPrice;
    }

    public boolean isSpecial() {
        return false;
    }

    public String toString() {
        System.out.printf("%s : %.2f %n", productName, productPrice);
        return null;
    }
}
