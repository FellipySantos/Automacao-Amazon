package br.com.amazon.steps;

import br.com.amazon.pages.HomePage;
import br.com.amazon.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MenuSteps {
    private WebDriver driver;
    private HomePage homePage;

    private static final Logger logger = LoggerFactory.getLogger(AutocompleteSteps.class);

    //Utilizando essa configuração de driver para testar os menus em modo mobile
    @Given("that I am accessing Amazon in mobile mode")
    public void openAmazonMobileMode() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        homePage.access();
    }

    //Coloquei o nome do menu hamburguer com Side menu, aqui vamos clicar para abrir ele
    @When("I open the side menu")
    public void openSideMenu() {
        homePage.openSideMenu();
    }

    //Esse metodo consegue clicar no menu lateral e no side menu então vou reaproveitar ele
    @And("I access the category {string}")
    @When("I access the menu {string}")
    public void accessMenu(String menu) {
        if (!homePage.accessMenuOption(menu)){
            logger.info("Invalid option");
        }

    }

    //Realizando as validações da página
    @Then("I must see products like {string}")
    public void checkPageName(String text) {
        Assert.assertTrue("Expected text not found on page.\n",
                homePage.validateTextPage(text));
    }

    @Then("I must see products in the category {string}")
    public void checkPageCategory(String category) {
        Assert.assertTrue("Expected text not found on page.\n",
                homePage.validatePageCategory(category));
    }

    @Then("I should not be redirected")
    public void checkInitialPage(){
        Assert.assertTrue(homePage.validateInitalPage());
    }
}