package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    static LinkedList<Product> products = new LinkedList<>();
    static LinkedList<Product> delProducts = new LinkedList<>();
    static int count;

    public static int sumBasket() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }
    public void printBasket(){
        int counter = 0;
        if (sumBasket() == 0) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Содержимое корзины:");
        for (Product product: products){
            if (product != null){
                System.out.println(product);
            }
            if (product != null && product.isSpecial()){
                counter++;
            }
        }
        System.out.println("Итого: " + sumBasket());
        System.out.println("Специальных товаров: " + counter);
    }
    public void clearBasket() {
        products = new LinkedList<>();
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
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Добавлен продукт: " +
                product.getName());
    }
    public LinkedList<Product> removeProduct(String name) {
        delProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if (product != null && product.getName().equals(name)) {
                delProducts.add(product);
                System.out.println("Удален продукт: " + product);
                iterator.remove();
            }
        }
        return delProducts;
    }
    public void printRemovedList(){
        System.out.println("Удаленные товары:");
        for (Product product : delProducts){
            System.out.println(product);
        }
        if (delProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
    }

    @Override
    public String toString() {
        return "ProductBasket{}";
    }
}
