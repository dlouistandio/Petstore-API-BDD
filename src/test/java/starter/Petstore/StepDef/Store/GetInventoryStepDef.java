package starter.Petstore.StepDef.Store;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.Petstore.StoreAPI;
import starter.Petstore.Utils.Constant;

import java.io.File;

public class GetInventoryStepDef {
    StoreAPI storeAPI;

    @When("Get inventory data request")
    public void getInventoryDataRequest() {
        SerenityRest.when().get(Constant.GET_ALL);
    }

    @And("Validate schema for Get inventory Json")
    public void validateSchemaForGetInventoryJson() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/GetInventorySchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get inventory data with valid path {string}")
    public void getInventoryDataWithValidPath(String path) {
        storeAPI.getInventory(path);
    }
}
