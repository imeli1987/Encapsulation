package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{

    int price;
    private final int discountPercent;

    public DiscountedProduct(String name, int price, int discountPercent) {
        super(name);
        this.price = price;
        this.discountPercent = discountPercent;
    }
    public int getDiscountPercent(){
        return this.discountPercent;
    }
    @Override
    public int getPrice() {
        return (int) (this.price * ( (double) 1 - ((double) this.discountPercent / 100)));
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
    @Override
    public boolean isFixPrice(){
        return false;
    }
    @Override
    public String toString() {
        return "DiscountedProduct{" +
                "basePrice=" + price +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
