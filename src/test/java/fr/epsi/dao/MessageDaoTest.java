package fr.epsi.dao;

import fr.epsi.model.Chanel;
import fr.epsi.model.Message;
import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageDaoTest {
    @Test
    public void insertMessage(){
        User user = new User();
        user.setEmail("benjamin.tourmant@epsi.fr");
        user.setPseudo("benjamin.tourmant");
        user.setPassword("test1234");
        long id = new UserDao().save(user);

        User u = new UserDao().get(id);

        Chanel chanel = new Chanel();
        chanel.setName("Test");
        chanel.setStatus(false);
        long idChanel = new ChanelDao().save(chanel);
        Chanel c =  new ChanelDao().get(idChanel);

        Message message = new Message();
        message.setAuteur(u);
        message.setChanel(c);
        message.setMessage("Test");
        long idMessage = new MessageDao().save(message);
        Message m = new MessageDao().get(idMessage);
        Assert.assertEquals("Test", m.getMessage());

    }

}