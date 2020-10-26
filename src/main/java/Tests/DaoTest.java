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
        Address address = new Address();
        address.setStreet("Av. JK");
        address.setHouseNumber(123);
        address.setDetails("Casa");
        address.setNeighbourhood("Centro");
        address.setCity("Juiz de fora");

//        Dao.getInstance().save(address);
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