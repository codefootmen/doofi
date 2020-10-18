package Model;
import lombok.Data;

@Data
public class Address {
    private Long addressId;
    private String street;
    private Integer houseNumber;
    private String details;
    private String neighbourhood;
    private String city;
}
