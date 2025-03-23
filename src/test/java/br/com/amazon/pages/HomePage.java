package br.com.amazon.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class HomePage {
    //Declarando locators e variaveis que vou utilizar mais de uma vez e que são estaticos
    private WebDriver driver;
    private WebDriverWait wait;
    private By searchField = By.cssSelector(".nav-input");
    private By searchSuggestions = By.cssSelector(".s-suggestion");

    private By hamburguerMenu = By.xpath("//*/header/div[1]/div[1]/div[1]/a/i");

    private By pageName = By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div/div[1]/div/div/div/h2/span");

    private By pageCategory = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div/span[1]");

    //construtor da nossa page
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //metodo de acesso ao site
    public void access() {
        driver.get("https://www.amazon.com.br");
    }

    //escrevendo na pagina de pesquisa
    public void typeSearch(String text) {
        WebElement input = driver.findElement(searchField);
        input.clear();
        input.sendKeys(text);

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                    ExpectedConditions.visibilityOfElementLocated(searchSuggestions)
            );
        } catch (Exception e){
            System.out.println("time out");
        }
        //Evitando falso negativo por timeout
    }

    //pegando as sugestões do autocomplete
    public List<WebElement> getSuggestions() {
        return driver.findElements(searchSuggestions);
    }

    //clicando em um menu com nome escolhido
    public boolean accessMenuOption(String option) {
        try {
            WebElement menuElement = driver.findElement(By.linkText(option));
            menuElement.click();
            return true;
        } catch (Exception e){
            return false;
        }
        //criei esse try catch para reaproveitar esse metodo em testes negativos
        // quando escrever os steps vou usar um if para verificar se o menu existe ou não
    }

    public void openSideMenu() {
        WebElement btnHamburguer = wait.until(ExpectedConditions.elementToBeClickable(hamburguerMenu));
        btnHamburguer.click();
    }



    //Metodos para validar se o link e o texto da página estão corretos
    public boolean validateTextPage(String text) {
        WebElement pageText = driver.findElement(pageName);

        if (pageText.getText().equals(text)){
            return true;
        }
        return false;
    }

    public boolean validatePageCategory(String text){
        WebElement pageCat = driver.findElement(pageCategory);
        if (pageCat.getText().equals(text)){
            return true;
        }
        return false;
    }

    public boolean validateInitalPage(){
        if(driver.getCurrentUrl().equals("https://www.amazon.com.br/")){
            return true;
        }
        return false;
    }

}