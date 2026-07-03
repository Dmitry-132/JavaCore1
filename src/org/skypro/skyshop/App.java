package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        SearchEngine searchEnginec = new SearchEngine();

        Product orange = new SimpleProduct("orange", 20);
        Product apple = new FixPriceProduct("apple");
        Product banana = new SimpleProduct("banana", 20);
        Product egg = new DiscountedProduct("egg", 15, 25);
        Product carrot = new FixPriceProduct("carrot");
        Product potato = new DiscountedProduct("potato", 10, 50);

        try {
            Product tomato = new DiscountedProduct("tomato", 18, 110);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Product cherry = new DiscountedProduct("", 18, 10);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e);
        }

        Article aboutPlantingOranges = new Article("about planting oranges",
                "Oranges can be grown in various ways: from seeds at home or in the open field");
        Article eggsExpensive = new Article("Eggs are expensive",
                "Retail egg prices continued to fall in February, according to the latest consumer price index." +
                        " Prices are now down 42.1% from a year ago.");

        searchEnginec.add(orange);
        searchEnginec.add(apple);
        searchEnginec.add(banana);
        searchEnginec.add(egg);
        searchEnginec.add(carrot);
        searchEnginec.add(potato);
        searchEnginec.add(aboutPlantingOranges);
        searchEnginec.add(eggsExpensive);

        try {
            System.out.println();
            searchEnginec.searchTheBest("e");
            searchEnginec.searchTheBest("egeref");
        } catch (BestResultNotFound n) {
            System.out.println(n);
        }
        searchEnginec.search("Egg");
        searchEnginec.search("ban");
        searchEnginec.search("machinegun");
        searchEnginec.search(" ");
        basket.addProduct(orange);
        basket.addProduct(orange);
        basket.addProduct(orange);
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(egg);
        basket.addProduct(carrot);
        basket.addProduct(potato);
        basket.contentBasket();
//        basket.totalCostBasket();
//        basket.searchProduct("Orange");
//        basket.searchProduct("Potato");
//        basket.totalCleaningBasket();
//        basket.contentBasket();
//        basket.totalCostBasket();
        basket.searchProduct("Orange");
        basket.searchProduct("orange");
        basket.removeProduct("orange");
        basket.contentBasket();
        basket.removeProduct("orange");
    }
}
