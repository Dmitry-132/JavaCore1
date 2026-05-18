package org.skypro.skyshop.product;

public class FixPriceProduct extends Product  {

    private static final double  FIX_PRICE = 6;

    public FixPriceProduct(String productName) {
        super(productName,FIX_PRICE);
    }
//    @Override
    public double getProductPrice() {
        return FIX_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        System.out.printf("%s : фиксированная цена %.2f %n", productName, productPrice);
        return null;
    }
}
