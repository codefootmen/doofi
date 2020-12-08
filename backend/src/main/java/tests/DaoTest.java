package tests;

import actions.ChangeStateToAcceptedAction;
import actions.ICommand;
import com.google.gson.Gson;
import model.*;
import persistence.Dao;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

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
                .currentStatus("Sent")
                .orderDescription("Pelo amor de Deus....")
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        ICommand command = new ChangeStateToAcceptedAction();

        Gson gs = new Gson();
        boolean response = (boolean) command.execute(gs.toJson(order), 0);

        assertTrue(response);
    }
}