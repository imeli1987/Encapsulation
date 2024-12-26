package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    static int PRICE = 400;

    public FixPriceProduct(String name) {
        super(name);
    }
    @Override
    public int getPrice() {
        return PRICE;
    }
    @Override
    public boolean isSpecial(){
        return true;
    }

    @Override
    public String toString() {
        return getName() +
                " с фиксированной ценой: " +
                getPrice();
    }
}
