package starter.Petstore;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Petstore.Utils.Constant;

import java.io.File;

public class StoreAPI {
    public static String POST_ORDER = Constant.BASE_URL + "";

    @Step ("Post order for new pet")
    public void postOrder(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
