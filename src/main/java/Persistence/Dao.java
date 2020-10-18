package Persistence;

import Model.Annotations.DataElement;
import Utils.AnnotationHelper;
import lombok.SneakyThrows;

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

    private String createQueryFromFields(Field[] fields, String tableName, long id) {
        StringBuilder param = new StringBuilder();

        for(Field f : fields){
            param.append(AnnotationHelper.getKey(f));
            if(fields[fields.length - 1] != f)
                param.append(",");
        }

        String primaryKey = AnnotationHelper.getPrimaryKey(fields);

        StringBuilder query = new StringBuilder()
                .append("SELECT ")
                .append(param.toString())
                .append(" FROM ")
                .append(tableName)
                .append(" WHERE ")
                .append(primaryKey)
                .append(" = ")
                .append(id);

        return query.toString();
    }

    @SneakyThrows
    private Optional createObjectInstance(ResultSet rs, Field[] fields, Class<?> clazz) {

        Object obj = clazz.getDeclaredConstructor().newInstance();

        for(Field f : fields){
            f.setAccessible(true);
            f.set(obj, rs.getObject(AnnotationHelper.getKey(f)));
        }

        return Optional.of(obj);
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
