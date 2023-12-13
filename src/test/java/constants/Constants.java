package constants;

import static constants.Constants.Servers.SWAPI_URL;
import static constants.Constants.Path.SWAPI_PATH;

public class Constants {

    public static class RunVeriable {
        public static String server = SWAPI_URL;
        public static String path = SWAPI_PATH;
    }

    public static class Servers{
        public static String SWAPI_URL = "https://jsonplaceholder.typicode.com"; //тут было "https://swapi.dev"
        public static String GOOGLE_PLACES_PATH;
    }

    public static class Path{
        public static String SWAPI_PATH = ""; //тут было "/api"
        public static String GOOGLE_PLACES_PATH;
    }

    public static class Actions{
        //SWAPI
        public static String SWAPI_GET_PEOPLE = "/people/";
        //JsonPlaceHolder
        public static String JSON_PLACEHOLDER_GET = "/comments";
        public static String JSON_PLACEHOLDER_PUT = "/posts/1";
        public static String JSON_PLACEHOLDER_DELETE = "/posts/1";
        public static String JSON_PLACEHOLDER_POST = "/posts";
    }
}
