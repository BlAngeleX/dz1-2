package dz2;

import dz2.ann.login.Login;

/**
 * Created by admin on 19.11.2017.
 */
public class Authorization {

    private String name;

    @Login
    private String login;

    public Authorization (String name) {
        this.name = name;
        //LoginFromName.startCreateLogin(this);
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

}
