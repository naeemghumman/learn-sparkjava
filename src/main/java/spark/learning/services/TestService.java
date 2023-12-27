package spark.learning.services;

import org.json.JSONObject;
import spark.Request;
import spark.learning.db.DatabaseConnection;
import spark.learning.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static List<Map<String, Object>> findAllCompanies() {
        List<Map<String, Object>> companies = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM company");
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("id", rs.getInt("id"));
                row.put("name", rs.getString("name"));
                companies.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }
}
