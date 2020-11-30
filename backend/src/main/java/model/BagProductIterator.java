package model;

import java.util.ArrayList;
import java.util.Iterator;

public class BagProductIterator implements Iterator {
    private final ArrayList<Order> orders;
    private final ArrayList<Product> filteredProducts;
    private int index;

    public BagProductIterator(ArrayList<Order> orders, Category category) {
        this.orders = orders;
        this.filteredProducts = new ArrayList<>();

        for (Order order : orders) {
            if (order.getProduct().getCategory() == category) {
                this.filteredProducts.add(order.getProduct());
            }
        }

        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index != this.orders.size();
    }

    @Override
    public Product next() {
        Product current = this.filteredProducts.get(index);
        this.index++;
        return current;
    }
}
