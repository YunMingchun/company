package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class User extends Model {

    @Email
    @Required
    public String email;

    @Required
    public String password;

    public String userName;
    public boolean isAdmin;

    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public static User connect(String userName, String password) {
        return find("byUserNameAndPassword", userName, password).first();
    }
}