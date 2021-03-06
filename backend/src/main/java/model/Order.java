package model;

import lombok.Builder;
import model.annotations.DataElement;
import lombok.Data;
import persistence.Dao;
import states.IOrderState;
import states.OrderIsCreatedState;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@DataElement(key = "Orders")
public class Order {
    @DataElement(key = "order_id", primaryKey = true)
    private long orderId;

    @DataElement(key = "created_at")
    private Timestamp createdAt;

    @DataElement(key = "finished_at")
    private Timestamp finishedAt;

    @DataElement(key = "order_description")
    private String orderDescription;

    @DataElement(key = "quantity")
    private int quantity;

    @DataElement(key = "order_status")
    private String currentStatus;

    @DataElement(key = "client_id", foreignKey = true)
    private Client client;

    @DataElement(key = "product_id", foreignKey = true)
    private Product product;

    public Order(){}

    public Order(long orderId, Timestamp createdAt, Timestamp finishedAt, String orderDescription, int quantity, String status, Client client, Product product) {
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.orderDescription = orderDescription;
        this.quantity = quantity;
        this.currentStatus = status;
        this.client = client;
        this.product = product;
    }

    public Order(Order o){
        this.orderId = o.getOrderId();
        this.createdAt = o.getCreatedAt();
        this.finishedAt = o.getFinishedAt();
        this.orderDescription = o.getOrderDescription();
        this.quantity = o.getQuantity();
        this.currentStatus = o.getCurrentStatus();
        this.client = new Client(o.getClient());
        this.product = new Product(o.getProduct());
    }
}
