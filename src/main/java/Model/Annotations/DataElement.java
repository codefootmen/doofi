package Model.Annotations;

public @interface DataElement {
    public String key() default "";
    public boolean primaryKey() default false;
    public boolean foreignKey() default false;
}
