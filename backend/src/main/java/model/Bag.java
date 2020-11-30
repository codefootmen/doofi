package model;

import java.util.ArrayList;

public class Bag {

    private ArrayList<Order> orders;

    public Bag(ArrayList<Order> orders){
        this.orders = orders;
    }

    public BagProductIterator iterator(Category category){
        return new BagProductIterator(this.orders, category);
    }

}
