package dz2;

import dz2.ann.login.Login;
import dz2.ann.login.LoginFromName;

/**
 * Created by admin on 28.11.2017.
 */
public class AuthorizationWithoutName {

    @Login
    private String login;

    public AuthorizationWithoutName () throws NoSuchFieldException, IllegalAccessException {
        LoginFromName.startCreateLogin(this);
    }

    public String getLogin() {
        return login;
    }
}
