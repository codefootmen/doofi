package model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Bag {

    private ArrayList<Order> orders;
    private ArrayList<BagMemento> timeline;
    private int step;

    public Bag(ArrayList<Order> orders){
        this.orders = orders;
        this.timeline = new ArrayList<>();
        this.timeline.add(this.getMemento());
        this.step = 0;
    }

    public BagProductIterator iterator(Category category){
        return new BagProductIterator(this.orders, category);
    }

    public void addOrder(Order o ){
        this.orders.add(o);
    }

    public BagMemento getMemento(){
        BagMemento now = new BagMemento();

        ArrayList<Order> copy = new ArrayList<>();
        for(Order o : orders){
            copy.add(new Order(o));
        }
        now.setOrders(copy);
        return now;
    }

    public void setMemento(BagMemento now){
        this.orders = now.getOrders();
    }

    public ArrayList<Order> getOrders(){
        this.setMemento(this.timeline.get(this.step));
        return this.orders;
    }
    
    public void snapshot(){
        this.timeline.add(this.getMemento());
        this.step++;
    }
    
    public void rollback(){
        if(this.step > 0){
            this.step--;
        }
    }
    public void rollforward(){
        if(this.step <= this.timeline.size()){
            this.step++;
        }
    }
}
