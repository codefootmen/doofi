package Persistence;

import Model.Annotations.DataElement;
import Utils.AnnotationHelper;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dao implements IDao {

    private Connection dbConnection;

    private static IDao instance = new Dao();
    public static IDao getInstance() { return instance; }

    @SneakyThrows
    private Dao(){
        dbConnection = PostgreeConnection.getInstance().getConnection();
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

    private Class<?> getClassObject(Object dataObject) {
        Class<?> obj = dataObject.getClass();

        if(!obj.isAnnotationPresent(DataElement.class))
            throw new IllegalArgumentException("This type is not allowed!");

        return obj;
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

    @SneakyThrows
    private String createInsertQuery(Object dataObject) {
        Class<?> obj = getClassObject(dataObject);

        String tableName = AnnotationHelper.getKey(obj);
        Field[] fields = obj.getDeclaredFields();


        StringBuilder param = new StringBuilder();
        StringBuilder values = new StringBuilder();

        param.append("(");
        values.append("(");
        for(Field f : fields){

            if(AnnotationHelper.isPrimaryKey(f))
                continue;

            f.setAccessible(true);
            if(isStringElement(f)){
                values.append("\'");
                values.append(f.get(dataObject));
                values.append("\'");
            }
            else{
                values.append(f.get(dataObject));
            }

            param.append(AnnotationHelper.getKey(f));
            if(fields[fields.length - 1] != f){
                values.append(",");
                param.append(",");
            }
        }
        values.append(")");
        param.append(")");

        StringBuilder query = new StringBuilder()
                .append("INSERT INTO ")
                .append(tableName)
                .append(param.toString())
                .append(" values ")
                .append(values);

        return query.toString();
    }

    private boolean isStringElement(Field f) {
        try{
            return String.class.isInstance(f.getType().getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void update(Object dataObject, String[] params) {

    }


    @Override
    public void delete(Object dataObject) {

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

    private String createQueryFromFields(Field[] fields, String tableName) {
        StringBuilder param = new StringBuilder();

        for(Field f : fields){
            param.append(AnnotationHelper.getKey(f));
            if(fields[fields.length - 1] != f)
                param.append(",");
        }

        StringBuilder query = new StringBuilder()
                .append("SELECT ")
                .append(param.toString())
                .append(" FROM ")
                .append(tableName);

        return query.toString();
    }

    @SneakyThrows
    private Optional createObjectInstance(ResultSet rs, Field[] fields, Class<?> clazz) {

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
