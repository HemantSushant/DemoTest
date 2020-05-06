package autoapp.automation.stepDef;

import autoapp.automation.pages.ShoppingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

public class ShoppingStepDef {
    @When("^I select summer dresses from the dresses megamenu$")
    public void i_select_menu_item_from_menu() throws Throwable {
        ShoppingPage.selectMenuItemFromMenuBar();
        System.out.println("when i over over dresses in megamenu");
    }

    @Then("^I should see the summer dresses webpage$")
    public void i_should_see_the_summer_dresses_webpage() {
        Assert.assertEquals("Selected Category","SUMMER DRESSES", ShoppingPage.getCategoryTitle());
        System.out.println("I should see the summer dresses webpage");
    }

    @And("^I select a dress$")
    public void i_select_a_dress() {
        ShoppingPage.selectOneDress();
    }

    @And("^I select blue colour")
    public void i_select_blue_colour() {
        ShoppingPage.selectBlueColour();
    }

    @And("^I add to shopping cart$")
    public void i_add_to_shopping_cart() {
        ShoppingPage.addToCart();
    }

    @Then("^the dress should appear in the Cart summary with same product name, colour and quantity$")
    public void verify_cart_details() {
        Assert.assertThat(ShoppingPage.getItemColor(), CoreMatchers.containsString("Blue"));
        Assert.assertThat(ShoppingPage.getItemName(), CoreMatchers.containsString("Summer Dress"));
        Assert.assertEquals("1", ShoppingPage.getItemQuantity());
    }

}
