package spark.learning.routes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import spark.learning.utils.JsonUtils;

import static spark.learning.services.TestService.*;

import static spark.Spark.*;
public class TestRoutes {

    private static final Logger log = LogManager.getLogger();

    public static void configureRoutes() {

        before("/*", (request, response) -> log.info("Received API call " + request.uri()));

        // GET http://localhost:8080/
        get("/", (req, res) -> hello());

        // GET http://localhost:8080/info
        get("/info", (req, res) -> {
            // Set the content type to JSON
            JsonUtils.setJsonContentType(res);
            return info(req);
        });

        // Getting named parameter - GET http://localhost:8080/greet/Learner
        get("/greet/:name", (req, res) -> greet(req));
    }
}
