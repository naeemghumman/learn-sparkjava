package spark.learning.utils;

import spark.Response;

public class JsonUtils {

    public static void setResponseTypeJson(Response response) {
        response.type("application/json");
    }
}
