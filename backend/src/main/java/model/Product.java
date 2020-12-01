package model;

import lombok.Builder;
import lombok.Data;
import model.annotations.DataElement;

@Data
@Builder
@DataElement(key = "Products")
public class Product {
    @DataElement(key = "product_id", primaryKey = true)
    private long productId;

    @DataElement(key = "product_name")
    private String name;

    @DataElement(key = "product_description")
    private String description;

    @DataElement(key = "unitary_value")
    private int unitaryValue;

    @DataElement(key = "business_id", foreignKey = true)
    private Business business;

    public Product(){}

    public Product(long productId, String name, String description, int unitaryValue, Business business) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.unitaryValue = unitaryValue;
        this.business = business;
    }

    public Product(Product p){
        this.productId = p.getProductId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.unitaryValue = p.getUnitaryValue();
        this.business = p.getBusiness();
    }

}
