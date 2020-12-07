package model;

import lombok.Builder;
import model.annotations.DataElement;
import lombok.Data;
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

//    0: order created
//    1: order accepted
//    2: order ready for delivery
//    3: order deliveried
//    4: order cancelled
    @DataElement(key = "order_status")
    private Integer status;

    @DataElement(key = "client_id", foreignKey = true)
    private Client client;

    @DataElement(key = "product_id", foreignKey = true)
    private Product product;

    private IOrderState currentStatus;

    public Order(IOrderState currentStatus) {
        if(currentStatus == null) this.currentStatus = OrderIsCreatedState.instance();

        this.currentStatus = currentStatus;
    }

    public Order(long orderId, Timestamp createdAt, Timestamp finishedAt, String orderDescription, int quantity, Integer status, Client client, Product product) {
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.orderDescription = orderDescription;
        this.quantity = quantity;
        this.status = status;
        this.client = client;
        this.product = product;
    }

    public Order(Order o){
        this.orderId = o.getOrderId();
        this.createdAt = o.getCreatedAt();
        this.finishedAt = o.getFinishedAt();
        this.orderDescription = o.getOrderDescription();
        this.quantity = o.getQuantity();
        this.client = new Client(o.getClient());
        this.product = new Product(o.getProduct());
    }

    public void updateStatus()
    {
        currentStatus.setState(this);
    }
}
