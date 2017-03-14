import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 14.03.2017.
 */
public class GetterTest {

    Getter cut = new Getter();

    // Test data
    private static final String NAME = "volvo";
    private final Integer PS = Integer.valueOf(100);
    private static final int YEAR = 1995;
    private final Car CAR = new Car(NAME, PS, YEAR);
    private final Car CAR_NO_PS = new Car(NAME, null, YEAR);


    @Test
    public void get_field_values() throws Exception {

        Assert.assertEquals(NAME, cut.get(CAR, "name"));
        Assert.assertEquals(PS.toString(), cut.get(CAR, "ps"));
        Assert.assertEquals(String.valueOf(YEAR), cut.get(CAR, "year"));

    }

    @Test
    public void get_field_value_has_null_value() throws Exception {

        Assert.assertEquals(NAME, cut.get(CAR_NO_PS, "name"));
        Assert.assertEquals("null", cut.get(CAR_NO_PS, "ps"));
        Assert.assertEquals(String.valueOf(YEAR), cut.get(CAR_NO_PS, "year"));

    }

    @Test
    public void get_given_object_is_null() throws Exception {
        Assert.assertEquals(cut.getNullValue(), cut.get(null, "any"));
    }

    @Test
    public void get_field_not_found() throws Exception {
        Assert.assertEquals(Getter.ERROR_MESSAGE_NO_SUCH_FIELD, cut.get(CAR, "bla"));
    }


    private class Car {

        String name;
        Integer ps;
        int year;

        public Car(String name, Integer ps, int year) {
            this.name = name;
            this.ps = ps;
            this.year = year;
        }
    }
}