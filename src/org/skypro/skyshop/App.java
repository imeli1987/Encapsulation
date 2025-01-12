package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

        ProductBasket basket = new ProductBasket();

        DiscountedProduct product1 = new DiscountedProduct("Арабика", 500, 10);
        SimpleProduct product2 = new SimpleProduct("Кофе", 600);
        FixPriceProduct product3 = new FixPriceProduct("Чай");
        DiscountedProduct product4 = new DiscountedProduct("Кофе", 50, 20);
        SimpleProduct product5 = new SimpleProduct("Кофе", 250);
        DiscountedProduct product6 = new DiscountedProduct("Ананас", 800, 20);

        try {
            basket.addProduct(product1);
            basket.addProduct(product2);
            basket.addProduct(product3);
            basket.addProduct(product4);
            basket.addProduct(product5);
            basket.addProduct(product6);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении товара");
        }

        basket.printBasket();

        System.out.println(basket.equalsProduct("milk"));

        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);

        Article article1 = new Article("Сахар", "сладкий");
        Article article2 = new Article("Молоко", "2,5 %");
        Article article3 = new Article("Кофе", "Кофе Робуста");
        Article article4 = new Article("Кофе", "кофе арабика, производится из зёрен кофе сорта \"Арабика\". 100% кофе");
        Article article5 = new Article("Кофе", "Робуста");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);

        String query = "кофе";
        try {
            System.out.println(searchEngine.bestResult(query));
        } catch (BestResultNotFound e) {
            System.out.println("Подходящего товара не найдено");
        }

        basket.removeProduct("Кофе");
        basket.printRemovedList();
        basket.printBasket();

        basket.removeProduct("Кофе");
        basket.printRemovedList();
        basket.printBasket();

    }
}







