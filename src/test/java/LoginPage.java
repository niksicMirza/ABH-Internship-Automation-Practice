import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{

    private final String CREATE_AN_ACCOUNT_EMAIL = "test_email_example8@gmail.com";
    private final String EMAIL_ADDRESS = "mirza.niksic5@gmail.com";
    private final String PASSWORD = "123456";

    @FindBy(id = "email_create")
    private WebElement email_create;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "SubmitCreate")
    private WebElement submit_create;

    @FindBy(id = "SubmitLogin")
    private WebElement submit_login;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    private WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement createAccountError;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]")
    private WebElement loginError;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(){
        this.email.sendKeys(EMAIL_ADDRESS);
    }

    public void enterCreateEmailAddress(){
        this.email_create.sendKeys(CREATE_AN_ACCOUNT_EMAIL);
    }

    public void enterPassword(){
        this.passwd.sendKeys(PASSWORD);
    }

    public void pressCreateButton(){
        this.submit_create.click();
    }

    public void pressLoginButton(){
        this.submit_login.click();
    }

    public void verifyCreateAccountError(){
        this.createAccountError.isDisplayed();
    }

    public void verifyLoginError(){
        this.loginError.isDisplayed();
    }


}
