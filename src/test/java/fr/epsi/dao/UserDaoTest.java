package fr.epsi.dao;

import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.PersistenceException;

public class UserDaoTest {

    @Test
    public void insertUser() {
        User user = new User();
        user.setEmail("benjamin.tourmant@epsi.fr");
        user.setPseudo("benjamin.tourmant");
        user.setPassword("test1234");
        long id = new UserDao().save(user);

        User u = new UserDao().get(id);
        Assert.assertEquals("benjamin.tourmant", u.getPseudo());
    }

    @Test(expected = PersistenceException.class)
    public void uniqueEmail() {
        User user1 = new User();

        user1.setEmail("tourman.benjamin@gmail.com");

        User user2 = new User();

        user2.setEmail("tourman.benjamin@gmail.com");

        new UserDao().save(user1);
        new UserDao().save(user2);
    }



}
