package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    Product[] productBasket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                return;
            } else if (i == productBasket.length - 1) {
                System.out.println("Невозможно добавить продукт");
            }
        }
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
                ;
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

    public void totalCleaningBasket() {
        for (int i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
        }
        System.out.println("Корзина очищена\n");
    }
}
