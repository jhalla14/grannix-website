package controllers;

import models.User;

import org.codehaus.jackson.node.ObjectNode;
import play.api.libs.json.JsPath;
import play.libs.Json;
import play.mvc.*;

import views.html.*;
import views.html.about;
import views.html.index;

import java.util.List;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render());
    }

    public static Result about(){
        return ok(about.render());
    }

    public static Result users() {
        List<User> users = User.findAll();

        ObjectNode result = Json.newObject();
        result.put("name",users.get(0).toString());

        return ok(result);

    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result sayHello() {
        //create a new JSON response
        ObjectNode result = Json.newObject();

        String name = Json.stringify(result);

        if(name == null) {
            result.put("status", "KO");
            result.put("message", "Missing parameter [name]");
            return badRequest(result);
        } else {
            result.put("status", "OK");
            result.put("message", "Hello " + name);
            return ok(result);
        }
    }
  
}
