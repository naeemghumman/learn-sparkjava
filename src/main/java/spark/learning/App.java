package spark.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import spark.learning.routes.TestRoutes;

import static spark.Spark.*;

public class App {

    private static final Logger logger = LogManager.getLogger();
    public static void main( String[] args ) {
        port(8080);  // default port is 4567
        TestRoutes.configureRoutes();
        logger.info("Server running at http://localhost:" + port());
    }
}
