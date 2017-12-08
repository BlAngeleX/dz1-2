/**
 * Created by admin on 28.11.2017.
 */
public class Application {

    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("ASUS", 8, 50000.0f);
        Laptop laptop2 = new Laptop("Dell", 10, 40000.0f);
        Laptop laptop3 = new Laptop("Lenovo", 7, 20000.0f);
        System.out.println(laptop1.toString());
        System.out.println(laptop2.toString());
        System.out.println(laptop3.toString());
    }
}
