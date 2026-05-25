package org.skypro.skyshop.product;

import org.skypro.skyshop.Article.Searchable;

public abstract class Product implements Searchable {
    protected final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract boolean isSpecial();

    public abstract double getProductPrice();

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String typeContent() {
        return "PRODUCT";
    }
}
