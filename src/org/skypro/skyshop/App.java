package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        DiscountedProduct product1 = new DiscountedProduct("Арабика", 500, 10);
        SimpleProduct product2 = new SimpleProduct("Кофе в зёрнах", 600);
        FixPriceProduct product3 = new FixPriceProduct("Чай");
        DiscountedProduct product4 = new DiscountedProduct("Кофе", 50, 20);
        SimpleProduct product5 = new SimpleProduct("Кофе молотый", 250);
        DiscountedProduct product6 = new DiscountedProduct("Ананас", 800, 20);


        try {
            basket.addProduct(product1);
            basket.addProduct(product2);
            basket.addProduct(product3);
            basket.addProduct(product4);
            basket.addProduct(product5);
            basket.addProduct(product6);
            basket.addProduct(new SimpleProduct("Чай", 500));
            basket.addProduct(new DiscountedProduct("Чай", 300, 15));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при добавлении товара");
        }

        System.out.println();
        basket.printBasket();
        System.out.println();

        System.out.println(basket.equalsProduct("milk"));
        System.out.println();

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);

        Article article1 = new Article("Сахар", "сладкий");
        Article article2 = new Article("Молоко", "2,5 %");
        Article article3 = new Article("Кофе растворимый", "Кофе Робуста");
        Article article4 = new Article("Кофе черный", "кофе арабика, производится из зёрен кофе сорта \"Арабика\". 100% кофе");
        Article article5 = new Article("Кофе робуста", "Робуста");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);
        searchEngine.add(new Article("Чай", "Чай зелёный"));
        searchEngine.add(new Article("Чай", "Чай черный"));


        System.out.println();
        basket.removeProduct("Кофе");

        System.out.println();
        basket.printRemovedList();

        System.out.println();
        basket.printBasket();

        System.out.println();
        basket.removeProduct("Чй");

        System.out.println();
        basket.printRemovedList();

        System.out.println();
        basket.printBasket();

        System.out.println();

        String query = "Кфе";
        System.out.println(searchEngine.search(query));

    }
}







