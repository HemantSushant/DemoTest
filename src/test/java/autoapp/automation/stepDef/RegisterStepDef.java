package autoapp.automation.stepDef;

import autoapp.automation.pages.PersonalInfoPage;
import autoapp.automation.pages.RegisterPage;
import autoapp.automation.pages.ShoppingPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDef {

    @Given("^Automation practice application is opened$")
    public void automation_practice_application_is_opened() throws Throwable {
        RegisterPage.openApplication();
    }

    @When("^I click sign in$")
    public void i_click_sign_in() throws Throwable {
        RegisterPage.clickSignIn();

    }

    @And("^I create account with emailid \"([^\"]*)\"$")
    public void i_create_account_with_emailid(String emailId) throws Throwable {
        RegisterPage.createAccount(emailId);
        Thread.sleep(5000);
    }


    @Then("^I should be able to register with my below details$")
    public void i_should_be_able_to_register_with_my_below_details(DataTable dataTable) throws Throwable {
        PersonalInfoPage.enterPersonalInformation(dataTable);
        Thread.sleep(5000);
    }


    @Then("^I should see an invalid email address error message$")
    public void i_should_an_invalid_email_address_error_message() throws Throwable {
        RegisterPage.isEmailErrorMsgAppear();
    }

}
