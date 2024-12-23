package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    int price;

    public SimpleProduct(String name, int price){
        super(name);
        this.price = price;
    }
    @Override
    public boolean isFixPrice(){
        return false;
    }
    @Override
    public int getDiscountPercent(){
        return -1;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public boolean isSpecial(){
        return false;
    }

    @Override
    public String toString() {
        return "SimpleProduct{" +
                "price=" + price +
                '}';
    }
}
