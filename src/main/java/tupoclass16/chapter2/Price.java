package tupoclass16.chapter2;

/**
 * Created by zjm on 2016/11/2.
 */
public class Price {

    private  static Price INSTANCE = new Price(2);

    static int initPrice = 20;

    int currentPrice;

    public Price(int price){
        currentPrice = initPrice - price;
    }

    public static void main(String[] args) {
        System.out.println(Price.INSTANCE.currentPrice);
        Price p = new Price(2);
        System.out.println(p.currentPrice);
    }
}
