package Persistence;

import Model.Annotations.DataElement;
import Utils.AnnotationHelper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class Dao implements IDao {

    private Connection dbConnection;

    public Dao(Connection connection) {
        dbConnection = connection;
    }

    @Override
    public Optional get(Object dataObject, long id) {

        Class<?> obj = dataObject.getClass();

        if(!obj.isAnnotationPresent(DataElement.class))
            throw new IllegalArgumentException("This type is not allowed!");

        String tableName = AnnotationHelper.getKey(obj);

        Field[] fields = obj.getDeclaredFields();

        String primaryKey = AnnotationHelper.getPrimaryKey(fields);

        StringBuilder query = new StringBuilder()
                .append("SELECT * FROM ")
                .append(tableName)
                .append("WHERE ")
                .append(primaryKey)
                .append("=")
                .append(id);

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query.toString());
            rs.first();
            // TODO: Resolver como vou deserializar isso num objeto complexo genérico
            System.out.println(rs.getInt(primaryKey));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return Optional.empty();
    }


    @Override
    public List getAll(Object dataObject) {
        return null;
    }

    @Override
    public void save(Object dataObject) {

    }

    @Override
    public void update(Object dataObject, String[] params) {

    }

    @Override
    public void delete(Object dataObject) {

    }
}
