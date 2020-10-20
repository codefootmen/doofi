package Tests;

import Model.Address;
import Model.Client;
import Persistence.Dao;
import Persistence.IDao;
import Persistence.PostgreeConnection;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DaoTest {

    @SneakyThrows
    @Test
    void get_address() {
        Address address = new Address();

        Optional<Address> test = Dao.getInstance().get(address, 1);

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
        Address address = new Address();
        address.setStreet("Av. JK");
        address.setHouseNumber(123);
        address.setDetails("Casa");
        address.setNeighbourhood("Centro");
        address.setCity("Juiz de fora");

        //Dao.getInstance().save(address);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}