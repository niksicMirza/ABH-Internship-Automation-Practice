import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{

    GenerateCredentials generateCredentials = new GenerateCredentials();

    protected final String CREATE_AN_ACCOUNT_EMAIL = generateCredentials.emailAddressGenerator();

    @FindBy(id = "email_create")
    protected WebElement email_create;

    @FindBy(id = "SubmitCreate")
    private WebElement submit_create;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    private WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement createAccountError;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]")
    private WebElement loginError;


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
