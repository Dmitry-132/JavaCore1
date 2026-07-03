package org.skypro.skyshop.product;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    protected final String productName;

    public Product(String productName) throws NullPointerException{
        if (productName == null || productName.isBlank()) {
            throw new NullPointerException("имя продукта не задано");
        }
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
        return "< PRODUCT >";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(searchTerm(), ((Product) o).searchTerm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchTerm());
    }
}
