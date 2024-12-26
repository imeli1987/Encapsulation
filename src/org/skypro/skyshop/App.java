package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        DiscountedProduct product = new DiscountedProduct("Молоко", 500, 10);
        SimpleProduct product2 = new SimpleProduct("Кофе", 600);
        FixPriceProduct product3 = new FixPriceProduct("Чай");
        DiscountedProduct product4 = new DiscountedProduct("Спички", 50, 20);
        SimpleProduct product5 = new SimpleProduct("Лимон", 250);
        DiscountedProduct product6 = new DiscountedProduct("Ананас", 800, 20);


        basket.addProduct(product);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        ProductBasket.printedBasket();

        System.out.println(basket.equalsProduct("milk"));
        basket.clearBasket();
        basket.printedBasket();

    }
}
