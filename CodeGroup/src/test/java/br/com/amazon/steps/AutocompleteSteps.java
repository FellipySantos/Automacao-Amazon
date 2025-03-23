package br.com.amazon.steps;

import br.com.amazon.pages.HomePage;
import br.com.amazon.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteSteps {
    private WebDriver driver;
    private HomePage homePage;
    private List<WebElement> suggestions = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(AutocompleteSteps.class);


    @Given("that I am on the Amazon home page")
    public void openAmazonPage() {
        //instanciando o driver e a homePage
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        homePage.access();
    }

    @When("I search for {string}")
    public void search(String text) {
        homePage.typeSearch(text);
        logger.info("Searching for: {}", text);
        suggestions = homePage.getSuggestions();
        logger.info("Found {} suggestions", suggestions.size());
    }

    @Then("I should see suggestions that contain the text {string}")
    public void validateSuggestions(String termo) {
        //Verificando se existem sugestões.
        Assert.assertFalse("No suggestions were found.", suggestions.isEmpty());
        logger.info("No suggestions were found");
        //executando um for each para validar que as sugestões estão relacionadas com a busca
        for (WebElement sugestao : suggestions) {
            String text = sugestao.getText().toLowerCase();
            //utilizar os textos junto ao assert true/false, ajuda a entender o que occoreu caso o teste falhe
            Assert.assertTrue("Suggestion '"+ sugestao +"' does not contain the searched text: " + text,
                    text.contains(termo.toLowerCase()));
        }
    }

    @Then("I shouldn't see suggestions that contain the text {string}")
    public void validateEmptySuggestions(String termo) {
        //Teste negativo para não exibir sugestões em buscas invalidas
        Assert.assertTrue( suggestions.isEmpty());

    }
}