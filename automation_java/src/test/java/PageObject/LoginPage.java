package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rDriver){
        ldriver=rDriver;

        PageFactory.initElements(rDriver, this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[contains(@id,'Password')]")
    WebElement password;

    @FindBy(xpath = "//button[contains(@type,'submit')]")
    WebElement LoginBtn;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logout;

    public void enterEmail(String emailAdd){
        email.clear();
        email.sendKeys(emailAdd);
    }

    public void enterPassword(String pwd){
        password.clear();
        password.sendKeys(pwd);
    }

    public void clickOnLoginButton(){
        LoginBtn.click();
    }

    public void clickOnLoginOutButton(){
        logout.click();
    }
}