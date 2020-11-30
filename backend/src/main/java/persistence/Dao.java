package persistence;

import utils.AnnotationHelper;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static utils.QueriesCreateHelper.*;

public class Dao implements IDao {

    private Connection dbConnection;

    private static IDao instance = new Dao();
    public static IDao getInstance() { return instance; }

    @SneakyThrows
    private Dao(){
        ConnectionFactory factory = new ConnectionFactory();
        IConnector postgre = factory.getConnector(ConnectionType.POSTGRE);
        dbConnection = postgre.getConnection();
    }


    @Override
    public Optional get(Object dataObject, long id) {

        Class<?> obj = getClassObject(dataObject);

        String tableName = AnnotationHelper.getKey(obj);
        Field[] fields = obj.getDeclaredFields();

        String query = createQueryFromFields(fields, tableName, id);
        try {
            Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(query);
            rs.first();

            return createObjectInstance(rs, fields, obj);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }


    @Override
    public List getAll(Object dataObject) {
        Class<?> obj = getClassObject(dataObject);

        String tableName = AnnotationHelper.getKey(obj);
        Field[] fields = obj.getDeclaredFields();

        String query = createQueryFromFields(fields, tableName);
        List result = new ArrayList();
        try {
            Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                result.add(createObjectInstance(rs, fields, obj));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }


    @Override
    public void save(Object dataObject) {

        String query = createInsertQuery(dataObject);

        try {
            Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(Object dataObject) {
        String query = createUpdateQuery(dataObject);

        try {
            Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(Object dataObject) {
        String query = createDeleteQuery(dataObject);

        try {
            Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @SneakyThrows
    public Optional createObjectInstance(ResultSet rs, Field[] fields, Class<?> clazz) {

        Object obj = clazz.getDeclaredConstructor().newInstance();

        for(Field f : fields){
            f.setAccessible(true);

            if(AnnotationHelper.isForeignKey(f)){
                f.set(obj, get(f.getType().getDeclaredConstructor().newInstance(), rs.getLong(AnnotationHelper.getKey(f))).get());
                continue;
            }

            f.set(obj, rs.getObject(AnnotationHelper.getKey(f)));
        }

        return Optional.of(obj);
    }
}
