package Persistence;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    Optional<T> get(T dataObject, long id);
    List<T> getAll(T dataObject);
    void save(T dataObject);
    void update(T dataObject, String[] params);
    void delete(T dataObject);
}
