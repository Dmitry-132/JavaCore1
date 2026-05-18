package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product orange = new SimpleProduct("orange", 20);
        Product apple = new FixPriceProduct("apple");
        Product banana = new SimpleProduct("banana", 20);
        Product egg = new DiscountedProduct("egg", 15, 25);
        Product carrot = new FixPriceProduct("carrot");
        Product potato = new DiscountedProduct("potato", 10, 50);

        basket.addProduct(orange);
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(egg);
        basket.addProduct(carrot);
        basket.addProduct(potato);

        basket.contentBasket();
        basket.totalCostBasket();
        basket.searchProduct("Orange");
        basket.searchProduct("Potato");
        basket.totalCleaningBasket();
        basket.contentBasket();
        basket.totalCostBasket();
        basket.searchProduct("Orange");
    }
}
