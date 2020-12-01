package tests;

import model.Address;
import model.Client;
import model.Order;
import model.Product;
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
        Address address = new Address();

        Optional<Address> test = Dao.getInstance().get(address, 5);

        assertNotNull(test);
    }

    @SneakyThrows
    @Test
    void get_client() {
        Client client = new Client();

        Optional<Client> test = Dao.getInstance().get(client, 1);

        assertNotNull(test);
    }

    @Test
    void getAll_address() {
        Address address = new Address();

        List<Address> test = Dao.getInstance().getAll(address);

        assertFalse(test.isEmpty());
    }

    @Test
    void getAll_client() {
        Client client = new Client();

        List<Client> test = Dao.getInstance().getAll(client);

        assertFalse(test.isEmpty());
    }

    @Test
    void save() {
        Order order = new Order();
        Client client = new Client();
        client.setClientId(2);
        Product prod = new Product();
        prod.setProductId(1);
        order.setProduct(prod);
        order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        order.setClient(client);

        Dao.getInstance().save(order);
    }

    @Test
    void update() {
        Optional<Address> address = Dao.getInstance().get(new Address(), 4);
        address.get().setStreet("testando aaa");

        Dao.getInstance().update(address.get());
        Optional<Address> addressUpdated = Dao.getInstance().get(new Address(), address.get().getAddressId());

        assertTrue(address.equals(addressUpdated));
    }

    @Test
    void delete() {
//        Optional<Address> address = Dao.getInstance().get(new Address(), 5);
//        Dao.getInstance().delete(address.get());

        Optional<Address> addressDeleted = Dao.getInstance().get(new Address(), 5);
        assertEquals(addressDeleted, Optional.empty());
    }
}