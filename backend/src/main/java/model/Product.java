package model;

import lombok.Data;
import model.annotations.DataElement;

@Data
@DataElement(key = "Products")
public class Product {
    @DataElement(key = "product_id", primaryKey = true)
    private long productId;

    @DataElement(key = "product_name")
    private String name;

    @DataElement(key = "product_description")
    private String description;

    @DataElement(key = "unitary_value")
    private String unitaryValue;

    @DataElement(key = "business_id", foreignKey = true)
    private Business business;

    @DataElement(key = "product_category")
    private Category category;

    public Product(){}
    public Product(Product p){
        this.productId = p.getProductId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.unitaryValue = p.getUnitaryValue();
        this.business = p.getBusiness();
        this.category = p.getCategory();
    }

}
