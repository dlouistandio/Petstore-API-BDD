package starter.Petstore.Utils;

import org.jruby.ast.StrNode;

public class Constant {
    public static String BASE_URL = "https://petstore.swagger.io/v2";
    public static final String DIR = System.getProperty("user.dir");
    public static String JSON_REQUEST = DIR + "/src/test/resources/JSON/Request";
    public static String JSON_SCHEMA = DIR + "/src/test/resources/JSON/Schema";

    public static String STORE_ID = "id";
    public static String STORE_PET_ID = "petId";
}
