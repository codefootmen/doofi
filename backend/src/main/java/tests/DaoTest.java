package tests;

import actions.ChangeStateToAcceptedAction;
import actions.ChangeStateToSentStateAction;
import actions.GetAllOrdersAction;
import actions.ICommand;
import com.google.gson.Gson;
import controller.FrontController;
import model.*;
import persistence.Dao;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DaoTest {

    @SneakyThrows
    @Test
    void get_address() {
        Address address = Address.builder().build();

        Optional<Address> test = Dao.getInstance().get(address, 5);

        assertNotNull(test);
    }

    @SneakyThrows
    @Test
    void get_business() {
        Business business = Business.builder().businessId(1).build();

        Optional<Address> test = Dao.getInstance().get(business, business.getBusinessId());

        assertNotNull(test);
    }

    @SneakyThrows
    @Test
    void get_order() {
        Order order = Order.builder().orderId(1).build();

        Optional<Address> test = Dao.getInstance().get(order, order.getOrderId());

        assertNotNull(test);
    }

    @SneakyThrows
    @Test
    void get_client() {
        Client client = Client.builder().build();


        Optional<Client> test = Dao.getInstance().get(client, 1);

        assertNotNull(test);
    }

    @Test
    void getAll_address() {
        Address address = Address.builder().build();

        List<Address> test = Dao.getInstance().getAll(address);

        assertFalse(test.isEmpty());
    }

    @Test
    void getAll_client() {
        Client client = Client.builder().build();

        List<Client> test = Dao.getInstance().getAll(client);

        assertFalse(test.isEmpty());
    }

    @Test
    void save() {
        Order order = Order
                .builder()
                .client(Client.builder()
                        .clientId(2)
                        .build())
                .product(Product.builder()
                        .productId(1)
                        .build())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        Dao.getInstance().save(order);
    }

    @Test
    void update() {
        Optional<Order> order = Dao.getInstance().get(Order.builder().build(), 1);
        order.get().setFinishedAt(null);

        Dao.getInstance().update(order.get());
        Optional<Address> addressUpdated = Dao.getInstance().get(Address.builder().build(), order.get().getOrderId());

        assertTrue(order.equals(addressUpdated));
    }

    @Test
    void delete() {
//        Optional<Address> address = Dao.getInstance().get(new Address(), 5);
//        Dao.getInstance().delete(address.get());

        Optional<Address> addressDeleted = Dao.getInstance().get(Address.builder().build(), 5);
        assertEquals(addressDeleted, Optional.empty());
    }


    @Test
    void ChangeToCreatedState() {
        Order order = Order
                .builder()
                .orderId(1)
                .client(Client.builder()
                        .clientId(1)
                        .build())
                .product(Product.builder()
                        .productId(1)
                        .build())
                .currentStatus("Accepted")
                .orderDescription("Pelo amor de Deus....")
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        ICommand command = new ChangeStateToSentStateAction();

        Gson gs = new Gson();
        boolean response = (boolean) command.execute(gs.toJson(order), 0);

        assertTrue(response);
    }


    @Test
    void GetAllOrders() {
        ICommand command = new GetAllOrdersAction();

        Gson gs = new Gson();
        boolean response = (boolean) command.execute(gs.toJson(Order.builder().build()), 0);

        assertTrue(response);
    }

    @Test
    void HandleRequesPost(){
        FrontController controller = new FrontController();
        String req = "{\n" +
                "\"orderId\": 1,                \n" +
                "\"createdAt\": \"Nov 30, 2020 3:21:59 AM\",\n" +
                "                \"orderDescription\": \"teste123\",\n" +
                "                \"quantity\": 2,\n" +
                "                \"currentStatus\": \"Sent\",\n" +
                "                \"client\": {\n" +
                "                    \"clientId\": 1,\n" +
                "                    \"name\": \"Cliente Teste\",\n" +
                "                    \"cpf\": \"123.456.789-12\",\n" +
                "                    \"login\": \"ctest\",\n" +
                "                    \"password\": \"123456\",\n" +
                "                    \"address\": {\n" +
                "                        \"addressId\": 1,\n" +
                "                        \"street\": \"Rua 2\",\n" +
                "                        \"houseNumber\": 340,\n" +
                "                        \"details\": \"Casa\",\n" +
                "                        \"neighbourhood\": \"Centro\",\n" +
                "                        \"city\": \"Juiz de Fora\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"product\": {\n" +
                "                    \"productId\": 1,\n" +
                "                    \"name\": \"Batata Frita\",\n" +
                "                    \"description\": \"Batata Fritinha\",\n" +
                "                    \"unitaryValue\": 20,\n" +
                "                    \"business\": {\n" +
                "                        \"businessId\": 1,\n" +
                "                        \"name\": \"toshios bakery\",\n" +
                "                        \"cnpj\": \"123455678\",\n" +
                "                        \"address\": {\n" +
                "                            \"addressId\": 1,\n" +
                "                            \"street\": \"Rua 2\",\n" +
                "                            \"houseNumber\": 340,\n" +
                "                            \"details\": \"Casa\",\n" +
                "                            \"neighbourhood\": \"Centro\",\n" +
                "                            \"city\": \"Juiz de Fora\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            }";

        Response response = controller.handleRequest("ChangeStateToSentStateAction", req);
    }
}