package model;

import model.annotations.DataElement;
import lombok.Data;

@Data
@DataElement(key = "Clients")
public class Client {
    @DataElement(key = "client_id", primaryKey = true)
    private long clientId;

    @DataElement(key = "client_name")
    private String name;

    @DataElement(key = "cpf")
    private String cpf;

    @DataElement(key = "username")
    private String login;

    @DataElement(key = "user_password")
    private String password;

    @DataElement(key = "address_id", foreignKey = true)
    private Address address;

    public Client(){};

    public Client(Client c){
        this.clientId = c.getClientId();
        this.name = c.getName();
        this.cpf = c.getCpf();
        this.login = c.getLogin();
        this.password = c.getPassword();
        this.address = c.getAddress();
    }
}
