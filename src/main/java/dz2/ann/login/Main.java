package dz2.ann.login;

import dz2.Authorization;

/**
 * Created by admin on 28.11.2017.
 */
public class Main {

    /**
     * Метод main создан только для проверки объема покрытия классов, методов и строк тестами.
     * Можно удалить. Объем: классы 100%, методы 66% (конструктор не проверялся), стркои 88%.
     *
     * @param args
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String name = "abcde";
        Authorization authorization = new Authorization(name);
        System.out.println(authorization.getName());
        System.out.println(authorization.getLogin());
    }

}
