package Model;

import Model.Annotations.DataElement;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@DataElement(key = "Orders")
public class Order {
    @DataElement(key = "clients_id", primaryKey = true)
    private Long orderId;

    @DataElement(key = "created_at")
    private Timestamp createdAt;

    @DataElement(key = "finished_at")
    private Timestamp finishedAt;

    @DataElement(key = "order_description")
    private String orderDescription;

    @DataElement(key = "client_id", foreignKey = true)
    private Client client;
}
