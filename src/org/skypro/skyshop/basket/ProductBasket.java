package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class ProductBasket {
    static Product[] products = new Product[5];
    static int count;

    public boolean findProduct(){
        return count < products.length;
    }

    public static int sumBasket() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }
    public static void printBasket() {
        int counter = 0;
        if (sumBasket() == 0) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Содержимое корзины:");
        for (Product prod: products) {
            if (prod != null && prod.getDiscountPercent() < 0 && !prod.isFixPrice()) {
                System.out.println(prod.getName() +
                        ": " +
                        prod.getPrice());
            }

            if (prod != null && prod.isSpecial()){
                counter++;
            }
            if (prod != null &&
                    counter > 0 &&
                    prod.getDiscountPercent() >= 0 &&
                    prod.getDiscountPercent() <= 100){
                System.out.println(prod.getName() +
                        " со скидкой: " +
                        prod.getPrice() +
                        " (" + prod.getDiscountPercent() +
                        "%" +
                        ")"
                        );
            }
            if (prod != null && prod.isFixPrice()){
                System.out.println(prod.getName() +
                        " с фиксированной ценой: " +
                        prod.getPrice());
            }
        }
        System.out.println("Итого: " + sumBasket());
        System.out.println("Специальных товаров: " + counter);
    }
    public void clearBasket() {
        products = new Product[5];
        count = 0;
        System.out.println("Корзина очищена");
    }
    public boolean equalsProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(DiscountedProduct product) {
        if (findProduct()){
            products[count++] = product;
            System.out.println("Добавлен продукт: " +
                    product.getName());
        }
        else {
            System.out.println("Невозможно добавить продукт " +
                    product.getName() + ". Корзина переполнена");
        }
    }
    public void addProduct(SimpleProduct product) {
        if (findProduct()){
            products[count++] = product;
            System.out.println("Добавлен продукт: " +
                    product.getName());
        }
        else {
            System.out.println("Невозможно добавить продукт " +
                    product.getName() + ". Корзина переполнена");
        }
    }

    public void addProduct(FixPriceProduct product) {
        if (findProduct()){
            products[count++] = product;
            System.out.println("Добавлен продукт: " +
                    product.getName());
        }
        else {
            System.out.println("Невозможно добавить продукт " +
                    product.getName() + ". Корзина переполнена");
        }
    }

    @Override
    public String toString() {
        return "ProductBasket{}";
    }
}
