package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract int getPrice();
    public abstract boolean isSpecial();
    public abstract int getDiscountPercent();
    public abstract boolean isFixPrice();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
