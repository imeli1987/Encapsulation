package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        ProductBasket products = new ProductBasket();
        products.addProduct("Tea", 100);

        products.addProduct("Coffee", 100);
        products.addProduct("Milk", 100);
        products.addProduct("Bread", 100);
        products.addProduct("Butter", 100);

        products.sumBasket();
        products.printBasket();
        products.addProduct("Колбаса", 100);
        products.printBasket();
        System.out.println(products.equalsProduct("Tea"));
        products.clearBasket();
        products.printBasket();

        ProductBasket prod = new ProductBasket();
        prod.addProduct("Молоток", 1000);
        prod.printBasket();

    }
}
