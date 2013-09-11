package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Joshua Hall
 * Date: 9/9/13
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="my_user")
public class User extends Model {

    public String email;
    public String fullname;
    public boolean isAdmin;

    public User(String email, String fullname, boolean isAdmin) {
        this.email = email;
        this.fullname = fullname;
        this.isAdmin = isAdmin;
    }

    public static Model.Finder<String,User> find = new Model.Finder(String.class, User.class);

    /**
     * Retrieve all users.
     */
    public static List<User> findAll() {
        return find.all();
    }

}
