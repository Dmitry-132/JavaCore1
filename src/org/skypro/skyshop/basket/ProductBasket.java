package org.skypro.skyshop.basket;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    List<Product> productBasket = new ArrayList<>();

    public void addProduct(Product product) {
        productBasket.add(product);
    }

    public int size() {// Получить количество
        return productBasket.size();
    }

    public double totalCostBasket() {
        double totalCost = 0;
        for (Product testProduct : productBasket) {
            if (testProduct != null) {
                totalCost += testProduct.getProductPrice();
            }
        }
        System.out.println("Общая стоимость " + totalCost + "\n");
        return totalCost;
    }

    public void contentBasket() {
        double totalCost = 0;
        int specialProduct = 0;
        for (Product testProduct : productBasket) {
            if (testProduct != null) {
                totalCost += testProduct.getProductPrice();
                System.out.println(testProduct.toString());
                if (testProduct.isSpecial() == true) {
                    specialProduct += 1;
                }
            }

        }
        if (totalCost == 0) {
            System.out.println("в корзине пусто\n");
        } else {
            System.out.printf("Итого: %.2f %n", totalCost);
            System.out.println("Специальных товаров: " + specialProduct + "\n");
        }
    }

    public boolean searchProduct(String name) {
        System.out.println("Поиск товара под именем " + name);
        for (Product testProduct : productBasket) {
            if (testProduct == null) {
                System.out.println("Корзина пуста\n");
                return true;
            }
            if (testProduct.getProductName().equalsIgnoreCase(name)) {
                System.out.println("Успех\n");
                return true;
            }
        }
        System.out.println("товар не найден\n");
        return false;
    }

    public List<Product> removeProduct(String name) {
        System.out.println("Удаление товаров под именем " + name + " из корзины");
        List<Product> removedProducts = new ArrayList<>();
        if (name == null || name.isBlank()) {
            System.out.println("Поисковая строка пуста");
            return removedProducts;
        }
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста");
            return removedProducts;
        }

        Iterator<Product> iterator = productBasket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equalsIgnoreCase(name)) {
                removedProducts.add(product);
                iterator.remove();
                System.out.println("  Удалён: " + product);
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Товары с именем \"" + name + "\" не найдены\n");
        } else {
            System.out.println("Удалено " + removedProducts.size() + " товаров\n");
        }
        return removedProducts;
    }

    public void totalCleaningBasket() {
        productBasket.clear();
        System.out.println("Корзина очищена\n");
    }
}
