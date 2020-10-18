package Model;
import lombok.Data;

@Data
public class Client {
    private Long clientId;
    private String name;
    private String cpf;
    private String login;
    private String password;
    private Address address;


}
