package spark.learning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.learning.routes.TestRoutes;
import static spark.Spark.*;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {

        port(8080);                                // default port is 4567
//        port(443);                                // SSL enabled

//        secure("/path/to/keystore/localhost.keystore", "password", null, null);

        staticFiles.location("/public");    // src/main/resources/public/README.txt

        TestRoutes.configureRoutes();             // Configure routes

        if (port() == 443) {
            log.info("Server running at https://localhost:" + port());
        } else {
            log.info("Server running at http://localhost:" + port());
        }
    }
}
