package dz2;

import dz2.ann.login.Login;
import dz2.ann.login.LoginFromName;

/**
 * Created by admin on 19.11.2017.
 */
public class Authorization {

    private String name;

    @Login
    private String login;

    public Authorization (String name) throws NoSuchFieldException, IllegalAccessException {
        if (!name.trim().isEmpty())
            this.name = name;
        LoginFromName.startCreateLogin(this);
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

}
