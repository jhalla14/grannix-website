import com.avaje.ebean.Ebean;
import controllers.Application;
import models.User;
import play.GlobalSettings;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Joshua Hall
 * Date: 9/9/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Global extends GlobalSettings{

    public void onStart(Application app) {
        InitialData.insert(app);
    }

    static class InitialData {

        public static void insert(Application app) {
            if(Ebean.find(User.class).findRowCount() == 0) {

                Map<String,List<Object>> all = (Map<String,List<Object>>) Yaml.load("initial-data.yml");

                // Insert users first
                Ebean.save(all.get("users"));



            }
        }

    }
}
