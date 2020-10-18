package Model;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long orderId;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private String orderDescription;
    private Client client;
}
