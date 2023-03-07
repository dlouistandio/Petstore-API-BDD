package starter.Petstore;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Petstore.Utils.Constant;

import java.io.File;

public class StoreAPI {
    public static String POST_ORDER = Constant.BASE_URL + "/store/order";
    public static String GET_ORDER_WITH_ID = Constant.BASE_URL + "/store/order/{id}";


    @Step ("Post order for new pet")
    public void postOrder(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get order with id")
    public void getOrder(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get inventory data")
    public void getInventory(String path){
        SerenityRest.given()
                .pathParam("path",path);
    }



}
