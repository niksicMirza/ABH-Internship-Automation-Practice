import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends PageObject{

    private final String FIRST_NAME = "Tester";
    private final String LAST_NAME = "Tester";
    private final String EMAIL_ADDRESS = "test_email_example4@gmail.com";
    private final String PASSWORD = "123456";
    private final String DAY_OF_BIRTH = "26";
    private final String MONTH_OF_BIRTH = "10";
    private final String YEAR_OF_BIRTH = "1999";
    private final String FIRST_NAME_ADDRESS = "Tester";
    private final String LAST_NAME_ADDRESS = "Tester";
    private final String COMPANY = "Company";
    private final String ADDRESS = "Address 99";
    private final String CITY = "Sarajevo";
    private final String STATE = "Colorado";
    private final String ZIP = "71000";
    private final String COUNTRY = "United States";
    private final String ADDITIONAL_INFORMATION = "Some additional information.";
    private final String MOBILE_NUMBER = "061875968";
    private final String HOME_NUMBER = "033589654";
    private final String ADDRESS_ALIAS = "Address alias";


    @FindBy(id = "id_gender1")
    private WebElement male_gender;

    @FindBy(id = "id_gender2")
    private WebElement female_gender;

    @FindBy(id = "customer_firstname")
    private WebElement customer_firstname;

    @FindBy(id = "customer_lastname")
    private WebElement customer_lastname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "days")
    private WebElement day_of_birth;

    @FindBy(id = "months")
    private WebElement month_of_birth;

    @FindBy(id = "years")
    private WebElement year_of_birth;

    @FindBy(id = "newsletter")
    private WebElement newsletter;

    @FindBy(id = "optin")
    private WebElement special_offers;

    @FindBy(id = "firstname")
    private WebElement address_firstname;

    @FindBy(id = "lastname")
    private WebElement address_lastname;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement zip_code;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "other")
    private WebElement additional_information;

    @FindBy(id = "phone")
    private WebElement home_number;

    @FindBy(id = "phone_mobile")
    private WebElement phone_number;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    private WebElement createAccountError;

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    public void selectTitle(){
        this.male_gender.click();
    }

    public void enterFirstName(){
        this.customer_firstname.sendKeys(FIRST_NAME);
    }

    public void enterLastName(){
        this.customer_lastname.sendKeys(LAST_NAME);
    }

    public void enterEmailAddress(){
        this.email.clear();
        this.email.sendKeys(EMAIL_ADDRESS);
    }

    public void enterPassword(){
        this.passwd.sendKeys(PASSWORD);
    }

    public void enterDayOfBirth(){
        Select dayDropdown=new Select(day_of_birth);
        dayDropdown.selectByValue(DAY_OF_BIRTH);
    }

    public void enterMonthOfBirth(){
        Select monthDropdown=new Select(month_of_birth);
        monthDropdown.selectByValue(MONTH_OF_BIRTH);
    }

    public void enterYearOfBirth(){
        Select yearDropdown=new Select(year_of_birth);
        yearDropdown.selectByValue(YEAR_OF_BIRTH);
    }

    public void checkNewsletter(){
        this.newsletter.click();
    }

    public void checkSpecialOffer(){
        this.special_offers.click();
    }

    public void enterFirstNameAddress(){
        this.address_firstname.sendKeys(FIRST_NAME_ADDRESS);
    }

    public void enterLastNameAddress(){
        this.address_lastname.sendKeys(LAST_NAME_ADDRESS);
    }

    public void enterCompany(){
        this.company.sendKeys(COMPANY);
    }

    public void enterAddress(){
        this.address.sendKeys(ADDRESS);
    }

    public void enterAddress2(){
        this.address2.sendKeys(ADDRESS);
    }

    public void enterCity(){
        this.city.sendKeys(CITY);
    }

    public void selectState(){
        Select stateDropdown=new Select(state);
        stateDropdown.selectByVisibleText(STATE);
    }

    public void enterZipCode(){
        this.zip_code.sendKeys(ZIP);
    }

    public void selectCountry(){
        Select countryDropdown=new Select(country);
        countryDropdown.selectByVisibleText(COUNTRY);
    }

    public void enterAdditionalInformation(){
        this.additional_information.sendKeys(ADDITIONAL_INFORMATION);
    }

    public void enterHomeNumber(){
        this.home_number.sendKeys(HOME_NUMBER);
    }

    public void enterMobileNumber(){
        this.phone_number.sendKeys(MOBILE_NUMBER);
    }

    public void enterAddressAlias(){
        this.alias.clear();
        this.alias.sendKeys(ADDRESS_ALIAS);
    }

    public void pressRegisterButton(){
        this.submitAccount.click();
    }

    public void verifyCreateAccountError(){
        this.createAccountError.isDisplayed();
    }
}
