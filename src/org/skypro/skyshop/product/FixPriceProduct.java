package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final double FIX_PRICE = 6;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public double getProductPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s : фиксированная цена %.2f", productName, FIX_PRICE);
    }
}
