package Model;

import Model.Annotations.DataElement;
import lombok.Data;

@Data
@DataElement(key = "Businesses")
public class Business {
    @DataElement(key = "business_id",  primaryKey = true)
    private long businessId;

    @DataElement(key = "business_name")
    private String name;

    @DataElement(key = "cnpj")
    private String cnpj;

    @DataElement(key = "address_id", foreignKey = true)
    private Address address;
}
