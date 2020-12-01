package model;

import java.util.ArrayList;
import java.util.Iterator;

public class BagProductIterator implements Iterator {
    private final ArrayList<Order> orders;
    private int index;

    @Override
    public boolean hasNext() {
        return index != this.orders.size();
    }

    public BagProductIterator(ArrayList<Order> orders) {
        this.orders = orders;
        this.index = 0;
    }

    @Override
    public Product next() {
        Product current = orders.get(this.index).getProduct();
        this.index++;
        return current;
    }
}
