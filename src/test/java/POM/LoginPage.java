package POM;
import data.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{

    GenerateCredentials generateCredentials = new GenerateCredentials();

    public final String CREATE_AN_ACCOUNT_EMAIL = generateCredentials.emailAddressGenerator();

    @FindBy(id = "email_create")
    public WebElement email_create;

    @FindBy(id = "SubmitCreate")
    public WebElement submit_create;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    public WebElement createAccountError;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]")
    public WebElement loginError;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterCreateEmailAddress(){
        this.email_create.sendKeys(CREATE_AN_ACCOUNT_EMAIL);
    }

    public void pressCreateButton(){
        this.submit_create.click();
    }

    public void verifyCreateAccountError(){
        this.createAccountError.isDisplayed();
    }

    public void verifyLoginError(){
        this.loginError.isDisplayed();
    }

}
