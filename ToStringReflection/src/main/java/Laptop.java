import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by admin on 28.11.2017.
 */
public class Laptop {

    private String name;
    private int version;
    private float price;

    Laptop (String name, int version, float price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {

        String united = "";
        Class ClassOfLaptop = this.getClass();
        Field fields[] = ClassOfLaptop.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers()))
                field.setAccessible(true);
            try {
                united += "\t" + field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return united;
    }
}
