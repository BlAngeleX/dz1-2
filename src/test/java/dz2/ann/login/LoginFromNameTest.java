package dz2.ann.login;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import ru.levelup.dz2.Authorization;

import static org.junit.Assert.*;

/**
 * Created by admin on 28.11.2017.
 */
public class LoginFromNameTest {
    @Test
    @DisplayName("Тест на пустую строку имени")
    public void testCreateNewClassWithEmptyName() throws Exception {
            Assertions.assertFalse(Boolean.parseBoolean(new Authorization("").getLogin()));
            Assertions.assertFalse(Boolean.parseBoolean(new Authorization("  ").getLogin()));
            Assertions.assertFalse(Boolean.parseBoolean(new Authorization("ABC").getLogin()));
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

}