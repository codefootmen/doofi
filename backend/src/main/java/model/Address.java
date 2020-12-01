package model;

import model.annotations.DataElement;
import lombok.Data;

@Data
@DataElement(key = "Addresses")
public class Address {
    @DataElement(key = "address_id",  primaryKey = true)
    private long addressId;

    @DataElement(key = "street")
    private String street;

    @DataElement(key = "house_number")
    private int houseNumber;

    @DataElement(key = "details")
    private String details;

    @DataElement(key = "neighbourhood")
    private String neighbourhood;

    @DataElement(key = "city")
    private String city;

    public Address(){};
    public Address(Address a){
        this.addressId = a.getAddressId();
        this.street = a.getStreet();
        this.houseNumber = a.getHouseNumber();
        this.details = a.getDetails();
        this.neighbourhood = a.getNeighbourhood();
        this.city = a.getCity();
    }
}
