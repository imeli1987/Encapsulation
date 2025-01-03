package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        DiscountedProduct product1 = new DiscountedProduct("Молоко", 500, 10);
        SimpleProduct product2 = new SimpleProduct("Кофе", 600);
        FixPriceProduct product3 = new FixPriceProduct("Чай");
        DiscountedProduct product4 = new DiscountedProduct("Спички", 50, 20);
        SimpleProduct product5 = new SimpleProduct("Лимон", 250);
        DiscountedProduct product6 = new DiscountedProduct("Ананас", 800, 20);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        ProductBasket.printedBasket();

        System.out.println(basket.equalsProduct("milk"));
//        basket.clearBasket();
        ProductBasket.printedBasket();

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);


        Article article1 = new Article("Сахар", "сладкий");
        Article article2 = new Article("Молоко", "2,5 %");
        Article article3 = new Article("Чай", "Цейлонский");
        Article article4 = new Article("Кофе", "Арабика");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        System.out.println(Arrays.toString(searchEngine.search("Кофе")));
        System.out.println(Arrays.toString(searchEngine.search("Арабика")));
        
    }
}
