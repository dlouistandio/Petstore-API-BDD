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

    @Given("Post order with invalid json")
    public void postOrderWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/InvalidPostOrder.json");
        storeAPI.postOrder(json);
    }
}
