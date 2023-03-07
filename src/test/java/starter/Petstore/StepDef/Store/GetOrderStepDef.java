package starter.Petstore.StepDef.Store;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.Petstore.StoreAPI;
import starter.Petstore.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetOrderStepDef {
    StoreAPI storeAPI;

    @Given("Get pet order data with id {int}")
    public void getPetOrderData(int id) {
        storeAPI.getOrder(id);
    }


    @When("Get pet order request")
    public void getPetOrderRequest() {
        SerenityRest.when().get(StoreAPI.GET_ORDER_WITH_ID);
    }

    @And("Validate schema for Get Order Json")
    public void validateSchemaForGetOrderJson() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/GetOrderSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body contains id {int}")
    public void responseBodyContainsId(int id) {
        SerenityRest.then().body(Constant.STORE_ID,equalTo(id));
    }
}
