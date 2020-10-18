package Tests;

import Model.Address;
import Persistence.Dao;
import Persistence.IDao;
import Persistence.PostgreeConnection;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class DaoTest {

    @SneakyThrows
    @Test
    void get() {
        IDao dao = new Dao(PostgreeConnection.getConnection());
        Address address = new Address();

        Optional<Address> test = dao.get(address, 1);

        assertNotNull(test);
    }

    @Test
    void getAll() {
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