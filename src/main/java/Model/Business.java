package Model;
import lombok.Data;

@Data
public class Business {
    private Long businessId;
    private String name;
    private String cnpj;
    private Address address;
}
