package dz2.ann.login;


import dz2.AuthorizationWithoutName;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by admin on 19.11.2017.
 */
public class LoginFromName {

    private LoginFromName () {}

    public static void startCreateLogin (Object object) throws NoSuchFieldException, IllegalAccessException {
        boolean hasNameField = false;
        String name = "";
        Class ClassToAnnotate = object.getClass();
        final Field fields[] = ClassToAnnotate.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName() == "name") {
                if (Modifier.isPrivate(field.getModifiers()))
                    field.setAccessible(true);
                name = field.get(object).toString();
                hasNameField = true;
            }
        }
        if (hasNameField == true) { // проверка на наличие поля, иначе NoSuchFieldException
            Field fieldLogin = ClassToAnnotate.getDeclaredField("login");
            String reversedName = new StringBuffer(name).reverse().toString();
            fieldLogin.setAccessible(true);
            fieldLogin.set(object, reversedName);
        }
        else throw new NoSuchFieldException ("Field \"name\" doesn't exist.");

    }


}
