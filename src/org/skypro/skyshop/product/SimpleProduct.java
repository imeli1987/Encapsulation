package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

    final int price;

    public SimpleProduct(String name, int price){
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть положительной");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() +
                ": " +
                price;
    }
}
