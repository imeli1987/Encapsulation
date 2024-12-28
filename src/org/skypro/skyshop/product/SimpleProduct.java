package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

    final int price;

    public SimpleProduct(String name, int price){
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public boolean isSpecial(){
        return false;
    }

    @Override
    public String toString() {
        return getName() +
                ": " +
                price;
    }
}
