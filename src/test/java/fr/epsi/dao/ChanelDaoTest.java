package fr.epsi.dao;

import fr.epsi.model.Chanel;
import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChanelDaoTest {
    @Test
    public void insertChanel(){
        Chanel chanel = new Chanel();
        chanel.setName("Test");
        chanel.setStatus(false);
        long id = new ChanelDao().save(chanel);
        Chanel u = (Chanel) new ChanelDao().get(id);
        Assert.assertEquals("Test", u.getName());
    }
    @Test
    public void insertUser(){
        User user = new User();
        user.setEmail("benjamin.tourmant@epsi.fr");
        user.setPseudo("benjamin.tourmant");
        user.setPassword("test1234");
        long id = new UserDao().save(user);
        User u = new UserDao().get(id);
        List<User> userList = new ArrayList<>();
        userList.add(u);
        Chanel chanel = new Chanel();
        chanel.setName("Test");
        chanel.setStatus(true);
        chanel.setUsers(userList);
        long idChanel = new ChanelDao().save(chanel);
        Chanel uChanel = new ChanelDao().get(idChanel);
        Assert.assertEquals(user.getPseudo(), uChanel.getUsers().get(0).getPseudo());
    }


}