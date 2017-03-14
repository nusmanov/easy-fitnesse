import java.lang.reflect.Field;
import java.sql.Struct;

/**
 * Created by nodirbek on 14.03.2017.
 */

public class Getter {

    public static final String NULL_VALUE_DEFAULT = "null";
    public static final String ERROR_MESSAGE_NO_SUCH_FIELD = "NoSuchFieldException: the class doesn't have a field of a specified name";

    private String nullValue;

    public Getter() {
        nullValue = NULL_VALUE_DEFAULT;
    }
    public Getter(String nullValue) {
        this.nullValue = nullValue;
    }

    /**
     * Get the field value via reflection and return as String
     *
     * @param object    object
     * @param fieldName the name of the field of the given object
     * @return Return the field value via reflection and return as String
     */
    public String get(Object object, String fieldName) throws IllegalAccessException {

        if (object == null) {
            return nullValue;
        }

        Field field;
        try {
            field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
        } catch (NoSuchFieldException e){
            return ERROR_MESSAGE_NO_SUCH_FIELD;
        }


        Object value = field.get(object);

        if (value == null){
            return nullValue;
        }
        return value.toString();

    }

    /**
     * @return returns the null value
     */
    public String getNullValue() {
        return nullValue;
    }
}
