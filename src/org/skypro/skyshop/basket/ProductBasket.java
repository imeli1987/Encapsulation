package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    static Product[] products;
    static int count;

    public ProductBasket() {
        ProductBasket.products = new Product[5];
    }

    public boolean findProduct(){
        return count < products.length;
    }
    public void addProduct(String name, int price) {
        if (findProduct()){
            Product newProduct = new Product(name, price);
            products[count++] = newProduct;
            System.out.println("Добавлен продукт: " + name);
        }
        else {
            System.out.println("Невозможно добавить продукт " + name + ". Корзина переполнена");
        }
    }
    public int sumBasket() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }
    public void printBasket() {
        if (sumBasket() == 0) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Содержимое корзины:");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Общая стоимость корзины: " + sumBasket());
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
}
