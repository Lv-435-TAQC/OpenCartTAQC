package utils;

import entity.Product;

import java.util.ArrayList;

public class ProductEntityData {
    public final static Product canonEOS5D = new Product(30,"Canon EOS 5D",98.00,"Canon's press material for the EOS 5D states that it 'defines (a) new D-SLR category', while we're n");
    public final static Product HPLP3065 = new Product(47,"HP LP3065",122.00,"Stop your co-workers in their tracks with the stunning new 30-inch diagonal HP LP3065 Flat Panel Mon");
    public final static Product HTCTouchHD = new Product(28,"HTC Touch HD",122.00,"HTC Touch - in High Definition. Watch music videos and streaming content in awe-inspiring high defin");
    public final static Product iPhone = new Product(40,"iPhone",123.20 ,"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a name o");
    public final static Product macBook = new Product(43,"MacBook",602.00 ,"Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.16GHz,");

    public final static ArrayList<Product> twoProducts = new ArrayList<Product>() {
        {
            add(canonEOS5D);
            add(iPhone);
        }
    };
    public final static ArrayList<Product> threeProducts = new ArrayList<Product>() {
        {
            add(canonEOS5D);
            add(iPhone);
            add(HPLP3065);
        }
    };
    public final static ArrayList<Product> fourProducts = new ArrayList<Product>() {
        {
            add(canonEOS5D);
            add(iPhone);
            add(HPLP3065);
            add(HTCTouchHD);
        }
    };

}
