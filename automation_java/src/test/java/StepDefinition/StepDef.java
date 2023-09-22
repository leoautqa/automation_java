package StepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import PageObject.LoginPage;

public class StepDef {

    public WebDriver driver;
    public LoginPage loginPg;

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        
        // Configurar as opções do Chrome
        ChromeOptions options = new ChromeOptions();

        // Configurar o tamanho da janela
        options.addArguments("--start-maximized");

        // Inicializar o WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lpmuchinski\\Desktop\\Automation_Java\\automation5\\automation_java\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        
        loginPg = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url){
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String emailadd, String password){
        loginPg.enterEmail(emailadd);
        loginPg.enterPassword(password);
    }

    @When("Click on Login")
    public void click_on_login(){
        loginPg.clickOnLoginButton();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle){
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link(){
        loginPg.clickOnLoginOutButton();
    }

    @Then("close browser")
    public void close_browser(){
        driver.close();
        driver.quit();
    }

    @Then("Page Title should be {string}")
    public void Page_Title_should_be(String s) {
        // Write code here that turns the phrase above into concrete actions
    }
}