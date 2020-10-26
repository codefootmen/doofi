package Utils;

import Model.Annotations.DataElement;
import lombok.SneakyThrows;
import java.lang.reflect.Field;

public class QueriesCreateHelper {

    public static Class<?> getClassObject(Object dataObject) {
        Class<?> obj = dataObject.getClass();

        if(!obj.isAnnotationPresent(DataElement.class))
            throw new IllegalArgumentException("This type is not allowed!");

        return obj;
    }

    @SneakyThrows
    public static String createUpdateQuery(Object dataObject) {
        Class<?> obj = getClassObject(dataObject);

        String tableName = AnnotationHelper.getKey(obj);
        Field[] fields = obj.getDeclaredFields();

        StringBuilder updateValues = new StringBuilder();
        StringBuilder whereClause = new StringBuilder();
        for(Field f : fields){
            f.setAccessible(true);

            if(AnnotationHelper.isPrimaryKey(f)){
                if(whereClause.length() > 0)
                    whereClause.append(" and ");

                whereClause.append(AnnotationHelper.getKey(f));
                whereClause.append(" = ");
                whereClause.append(f.get(dataObject));
                continue;
            }

            updateValues.append(AnnotationHelper.getKey(f));
            updateValues.append(" = ");

            if(isStringElement(f)){
                updateValues.append("\'");
                updateValues.append(f.get(dataObject));
                updateValues.append("\'");
            }
            else{
                updateValues.append(f.get(dataObject));
            }

            if(fields[fields.length - 1] != f){
                updateValues.append(",");
            }
        }

        StringBuilder query = new StringBuilder()
                .append("UPDATE ")
                .append(tableName)
                .append(" SET ")
                .append(updateValues.toString())
                .append(" WHERE ")
                .append(whereClause.toString());

        return query.toString();
    }

    @SneakyThrows
    public static String createInsertQuery(Object dataObject) {
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

    private static boolean isStringElement(Field f) {
        try{
            return String.class.isInstance(f.getType().getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            return false;
        }
    }

    @SneakyThrows
    public static String createDeleteQuery(Object dataObject) {
        Class<?> obj = getClassObject(dataObject);

        String tableName = AnnotationHelper.getKey(obj);
        Field[] fields = obj.getDeclaredFields();

        StringBuilder whereClause = new StringBuilder();
        for(Field f : fields){
            if(AnnotationHelper.isPrimaryKey(f)){
                if(whereClause.length() > 0)
                    whereClause.append(" and ");

                f.setAccessible(true);
                whereClause.append(AnnotationHelper.getKey(f));
                whereClause.append(" = ");
                whereClause.append(f.get(dataObject));
            }
        }

        StringBuilder query = new StringBuilder()
                .append("DELETE FROM ")
                .append(tableName)
                .append(" WHERE ")
                .append(whereClause.toString());

        return query.toString();
    }


    public static String createQueryFromFields(Field[] fields, String tableName, long id) {
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


    public static String createQueryFromFields(Field[] fields, String tableName) {
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



}
