package starter.Petstore.StepDef.General;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class GeneralStepDef {
    @Then("Should return status code {int}")
    public void returnStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
}
