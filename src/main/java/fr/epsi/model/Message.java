package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Message")
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(optional=true)
    @JoinColumn(name="idUser",referencedColumnName="id", insertable=false, updatable=false)
    private User auteur;
    @ManyToOne(optional=true)
    @JoinColumn(name="idChanel",referencedColumnName="id", insertable=false, updatable=false)
    private Chanel chanel;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getAuteur() {
        return auteur;
    }

    public void setAuteur(User auteur) {
        this.auteur = auteur;
    }

    public Chanel getChanel() {
        return chanel;
    }

    public void setChanel(Chanel chanel) {
        this.chanel = chanel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
