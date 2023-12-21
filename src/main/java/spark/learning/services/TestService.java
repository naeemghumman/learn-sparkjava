package spark.learning.services;

import org.json.JSONObject;
import spark.Request;
import spark.learning.domain.User;

public class TestService {
    public static String hello() {
        String res = "Hello Java";
        return "Hello, Spark Java!";
    }

    public static String greet(Request req) {
        return "Hello, " + req.params(":name") + "!";
    }

    public static String info(Request request) {
        JSONObject json = new JSONObject();
        json.put("host", request.host());
        json.put("port", request.port());
        json.put("url", request.url());
        json.put("protocol", request.protocol());
        json.put("method", request.requestMethod());
        return json.toString();
    }

    public static User userInfo() {
        return new User("Naeem Ghumman", "naeemghumman01@gmail.com");
    }
}
