package model;

import model.annotations.DataElement;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
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

    @DataElement(key = "client_id", foreignKey = true)
    private Client client;

    @DataElement(key = "product_id", foreignKey = true)
    private Product product;

    public Order(Order o){
        this.orderId = o.getOrderId();
        this.createdAt = o.getCreatedAt();
        this.finishedAt = o.getFinishedAt();
        this.orderDescription = o.getOrderDescription();
        this.quantity = o.getQuantity();
        this.client = new Client(o.getClient());
        this.product = new Product(o.getProduct());
    }
}
