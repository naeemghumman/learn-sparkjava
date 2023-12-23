package spark.learning.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.learning.config.FreeMarkerTemplateEngine;
import spark.learning.services.UserService;
import spark.learning.transformers.JsonTransformer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.learning.utils.JsonUtils.*;
import static spark.learning.services.TestService.*;
import static spark.Spark.*;

public class TestRoutes {

    private static final Logger log = LoggerFactory.getLogger(TestRoutes.class);

    public static void configureRoutes() {

        before("/*", (request, response) -> log.info("Received API call " + request.uri()));

        // GET http://localhost:8080/
        get("/", (req, res) -> hello());

        // GET http://localhost:8080/info
        get("/info", (req, res) -> {
            // Set the content type to JSON
            setResponseTypeJson(res);
            return info(req);
        });

        // Getting named parameter - GET http://localhost:8080/greet/Learner
        get("/greet/:name", (req, res) -> greet(req));

        // Use of JsonTransformer
        get("/kids", "application/json", (req, res) -> {
            setResponseTypeJson(res);
            return UserService.getUsers();
        }, new JsonTransformer());

        // Using Free Marker templates http://localhost:8080/users
        get("/users", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("users", UserService.getUsers());
            return new FreeMarkerTemplateEngine().render(
                    new ModelAndView(model, "users-info.ftl")
            );
        });
    }
}
