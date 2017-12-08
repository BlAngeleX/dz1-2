package dz2.ann.login;

import dz2.AuthorizationWithoutName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelup.dz2.Authorization;

/**
 * Created by admin on 28.11.2017.
 */
public class LoginFromNameTest {
    @Test
    @DisplayName("Тест на пустую строку имени")
    public void testCreateNewClassWithEmptyName() throws Exception {
            Assertions.assertFalse(new Authorization("").getLogin() == "");
            Assertions.assertFalse(new Authorization("   ").getLogin() == "   ");
    }

    @Test
    @DisplayName("Тест на правильное зеркальное отображение имени")
    public void testCreateLogin() throws Exception {
        String name = "abcde";
        Authorization authorization = new Authorization(name);
        char [] charedName = authorization.getName().toCharArray();
        char [] charedLogin = authorization.getLogin().toCharArray();
        for (int i = 0; i < authorization.getName().length(); i++)
            Assertions.assertTrue(charedName[i] == charedLogin[authorization.getName().length()-1-i]);
    }

    @Test
    @DisplayName("Тест на Exception")
    public void testCreateNameException() {
        try {
            AuthorizationWithoutName authorization = new AuthorizationWithoutName();
            Assertions.assertTrue(false);
        } catch (NoSuchFieldException e) {
            Assertions.assertTrue(true);
        } catch (IllegalAccessException e) {
            Assertions.assertTrue(false);
        }
    }
}