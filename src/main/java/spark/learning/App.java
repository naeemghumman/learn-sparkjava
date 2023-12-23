package spark.learning;

import spark.learning.routes.TestRoutes;
import static spark.Spark.*;

public class App {

    public static void main( String[] args ) {

        port(8080);                                // default port is 4567
//        port(443);                                // SSL enabled

//        secure("/path/to/keystore/localhost.keystore", "password", null, null);

        staticFiles.location("/public");    // src/main/resources/public/README.txt

        TestRoutes.configureRoutes();             // Configure routes

        if (port() == 443) {
            System.out.println("Server running at https://localhost:" + port());
        } else {
            System.out.println("Server running at http://localhost:" + port());
        }
    }
}
