package Model;

import Model.Annotations.DataElement;
import lombok.Data;

@Data
@DataElement(key = "Addresses")
public class Address {
    @DataElement(key = "address_id",  primaryKey = true)
    private Long addressId;

    @DataElement(key = "street")
    private String street;

    @DataElement(key = "house_number")
    private Integer houseNumber;

    @DataElement(key = "details")
    private String details;

    @DataElement(key = "neighbourhood")
    private String neighbourhood;

    @DataElement(key = "neighbourhood")
    private String city;
}
