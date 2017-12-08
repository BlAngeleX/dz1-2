package dz2.ann.login;

import dz2.Authorization;

import java.lang.reflect.Field;

/**
 * Created by admin on 19.11.2017.
 */
public class LoginFromName {

    private LoginFromName () {}

    public static void startCreateLogin (Authorization authorization) throws NoSuchFieldException, IllegalAccessException {
        boolean bName = false, bLogin = false;
        Class ClassToAnnotate = Authorization.class;
        final Field fields[] = ClassToAnnotate.getDeclaredFields();
//        for (Field field : fields) {
//            if (field.getName() == "name")
//                bName = true;
//            if (field.getName() == "login")
//                bLogin = true;
//        }
//        if (bName != true || bLogin != true)
//            throw new RuntimeException("NoSuchFieldException");
//        else {
            ClassToAnnotate.getDeclaredField("name");
            Field fieldLogin = ClassToAnnotate.getDeclaredField("login");
            String name = authorization.getName();
            String reversedName = new StringBuffer(name).reverse().toString();
            fieldLogin.setAccessible(true);
            fieldLogin.set(authorization, reversedName);
        //}

    }
}
