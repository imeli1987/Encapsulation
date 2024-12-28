package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }


    public boolean isSpecial(){
        return false;
    }
    public int getPrice() {
        return 0;
    }
    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }
}
