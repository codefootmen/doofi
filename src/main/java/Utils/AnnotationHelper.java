package Utils;

import Model.Annotations.DataElement;

import java.lang.reflect.Field;

public class AnnotationHelper {

    public static String getPrimaryKey(Field[] fields){
        for(Field f : fields){
            if(isPrimaryKey(f)){
                return getKey(f);
            }
        }
        return null;
    }

    public static String getKey(Field f) {
        String value = f.getAnnotation(DataElement.class)
                .key();
        return value.isEmpty() ? f.getName() : value;
    }


    public static String getKey(Class<?> c) {
        String value = c.getAnnotation(DataElement.class)
                .key();
        return value.isEmpty() ? c.getName() : value;
    }

    public static boolean isPrimaryKey(Field f) {
        return f.getAnnotation(DataElement.class)
                .primaryKey();
    }

    public static boolean isForeignKey(Field f) {
        return f.getAnnotation(DataElement.class)
                .foreignKey();
    }
}
