package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product orange = new Product("orange", 20);
        Product apple = new Product("apple", 17);
        Product banana = new Product("banana", 20);
        Product egg = new Product("egg", 15);
        Product carrot = new Product("carrot", 17);
        Product potato = new Product("potato", 15);

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
