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
        IDao dao = Dao.getInstance();
        Address address = new Address();

        Optional<Address> test = dao.get(address, 1);

        assertNotNull(test);
    }

    @SneakyThrows
    @Test
    void get_client() {
        IDao dao = Dao.getInstance();
        Client client = new Client();

        Optional<Client> test = dao.get(client, 1);

        assertNotNull(test);
    }

    @Test
    void getAll() {

        IDao dao = Dao.getInstance();
        Address address = new Address();

        List<Address> test = dao.getAll(address);

        assertFalse(test.isEmpty());
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}