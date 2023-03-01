package starter.Petstore.StepDef.Store;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Petstore.StoreAPI;
import starter.Petstore.Utils.Constant;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;

public class PostOrderStepDef {
    @Steps
    StoreAPI storeAPI;

    @Given("Post order with valid json")
    public void postOrderWithValidJson(){
        File json = new File(Constant.JSON_REQUEST + "");
        storeAPI.postOrder(json);
    }

    @When("Send request post order")
    public void sendRequestPostOrder(){
        SerenityRest.when()
                .post(storeAPI.POST_ORDER);
    }

    @Then("Should return status code {int}")
    public void returnStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
    
    @And("Response body contains {int} and {int}")
    public void responseBodyContainsIdAndPetId(int id, int petId){
        SerenityRest.then()
                .body(Constant.STORE_ID,equalTo(id))
                .body(Constant.STORE_PET_ID,equalTo(petId));
    }

    @And("Validate schema for Post Order Json")
    public void validateSchemaForPostOrderJson(){
        File jsonSchema = new File(Constant.JSON_SCHEMA + "");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
