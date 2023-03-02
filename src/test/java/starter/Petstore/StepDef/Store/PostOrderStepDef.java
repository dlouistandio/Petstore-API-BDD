package starter.Petstore.StepDef.Store;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.pdfbox.contentstream.operator.state.SetRenderingIntent;
import starter.Petstore.StoreAPI;
import starter.Petstore.Utils.Constant;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;

public class PostOrderStepDef {
    @Steps
    StoreAPI storeAPI;

    @Given("Post order with valid json")
    public void postOrderWithValidJson(){
        File json = new File(Constant.JSON_REQUEST + "/PostOrder.json");
        storeAPI.postOrder(json);
    }

    @When("User send request post order")
    public void sendRequestPostOrder(){
        SerenityRest.when()
                .post(storeAPI.POST_ORDER);
    }

    @Then("Should return status code {int}")
    public void returnStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
    
    @And("Response body contains id {int} and pet id {int}")
    public void responseBodyContainsIdAndPetId(int id, int petId){
        SerenityRest.then()
                .body(Constant.STORE_ID,equalTo(id))
                .body(Constant.STORE_PET_ID,equalTo(petId));
    }

    @And("Validate schema for Post Order Json")
    public void validateSchemaForPostOrderJson(){
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/OrderPostSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

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

    @When("Get inventory data request")
    public void getInventoryDataRequest() {
        SerenityRest.when().get(StoreAPI.GET_ALL);
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
