package tupoclass16.chapter2;

/**
 * Created by zjm on 2016/11/2.
 */
public class FinalPrice {

    final static FinalPrice INSTANCE = new FinalPrice(2);
    final static int initPrice = 20;
    int currentPrice;
    public FinalPrice(int price){
        currentPrice = initPrice - price;
    }

    public static void main(String[] args) {
        System.out.println(FinalPrice.INSTANCE.currentPrice);
        FinalPrice p = new FinalPrice(2);
        System.out.println(p.currentPrice);
    }
}
