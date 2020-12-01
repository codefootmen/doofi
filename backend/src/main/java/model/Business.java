package model;

import lombok.Builder;
import model.annotations.DataElement;
import lombok.Data;

@Data
@Builder
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

    public Business() {
    }

    public Business(long businessId, String name, String cnpj, Address address) {
        this.businessId = businessId;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
    }
}
