package org.skypro.skyshop.basket;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String, List<Product>> productBasket = new HashMap<>();

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getProductName().toLowerCase(), k -> new ArrayList<>()).add(product);
    }

    public int size() {
        int totalCount = 0;
        for (List<Product> productList : productBasket.values()) {  // values() — возвращает все значения
            totalCount += productList.size();
        }
        return totalCount;
    }


    public double totalCostBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста\n");
            return 0;
        }
        double totalCost = 0;
        for (List<Product> productList : productBasket.values()) {
            for (Product testProduct : productList) {
                if (testProduct != null) {
                    totalCost += testProduct.getProductPrice();
                }
            }
        }
        System.out.println("Общая стоимость " + totalCost + "\n");
        return totalCost;
    }

    public void contentBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("В корзине пусто\n");
        }
        double totalCost = 0;
        int specialProduct = 0;
        for (Map.Entry<String, List<Product>> entry : productBasket.entrySet()) { //выведет все пары ключ — значение из map в entry
            for (Product testProduct : entry.getValue()) {
                if (testProduct != null) {
                    totalCost += testProduct.getProductPrice();
                    System.out.println(testProduct);
                    if (testProduct.isSpecial()) {
                        specialProduct += 1;
                    }
                }
            }
        }
        System.out.printf("Итого: %.2f %n", totalCost);
        System.out.println("Специальных товаров: " + specialProduct + "\n");
    }

    public boolean searchProduct(String name) {
        System.out.println("Поиск товара под именем " + name);
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста\n");
            return false;
        }
        if (name == null || name.isBlank()) {
            System.out.println("Поисковый запрос пуст\n");
            return false;
        }
        if (productBasket.containsKey(name.toLowerCase())) {
            System.out.println("Успех\n");
            return true;
        }
        System.out.println("товар не найден\n");
        return false;
    }

    public List<Product> removeProduct(String name) {
        System.out.println("Удаление товаров под именем " + name + " из корзины");
        if (name == null || name.isBlank()) {
            System.out.println("Строка запроса на удаление продукта пуста\n");
            return new ArrayList<>();
        }
        List<Product> removedProduct = productBasket.remove(name.toLowerCase());
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста");
            return removedProduct;
        }
        if (removedProduct == null || removedProduct.isEmpty()) {
            System.out.println("Товары с именем \"" + name + "\" не найдены\n");
            return removedProduct;
        }
        System.out.println("Удалено " + removedProduct.size() + " njdfhjd\n");
        return removedProduct;
    }

    public void totalCleaningBasket() {
        productBasket.clear();
        System.out.println("Корзина очищена\n");
    }
}
