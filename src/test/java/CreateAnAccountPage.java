import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends PageObject{

    GenerateCredentials generateCredentials = new GenerateCredentials();


    protected final String FIRST_NAME = "Tester";
    protected final String LAST_NAME = "Tester";
    protected final String ENCODED_PASSWORD = generateCredentials.encodePassword(GenerateCredentials.passwordGenerator());
    protected final String PASSWORD = generateCredentials.decodePassword(ENCODED_PASSWORD);
    protected final String DAY_OF_BIRTH = "14";
    protected final String MONTH_OF_BIRTH = "10";
    protected final String YEAR_OF_BIRTH = "1983";
    protected final String FIRST_NAME_ADDRESS = "Tester";
    protected final String LAST_NAME_ADDRESS = "Tester";
    protected final String COMPANY = "Atlantbh";
    protected final String ADDRESS = "Ruzevik 22";
    protected final String CITY = "Sarajevo";
    protected final String STATE = "Alabama";
    protected final String STATE_VALUE = "1";
    protected final String ZIP = "71251";
    protected final String COUNTRY = "United States";
    protected final String COUNTRY_VALUE = "21";
    protected final String ADDITIONAL_INFORMATION = "Nulla quis lorem ut libero malesuada feugiat.";
    protected final String MOBILE_NUMBER = "0636587";
    protected final String HOME_NUMBER = "0335964";
    protected final String ADDRESS_ALIAS = "My address";


    @FindBy(id = "id_gender1")
    protected WebElement male_gender;

    @FindBy(id = "id_gender2")
    protected WebElement female_gender;

    @FindBy(id = "customer_firstname")
    protected WebElement customer_firstname;

    @FindBy(id = "customer_lastname")
    protected WebElement customer_lastname;

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(id = "passwd")
    protected WebElement passwd;

    @FindBy(id = "days")
    protected WebElement day_of_birth;

    @FindBy(id = "months")
    protected WebElement month_of_birth;

    @FindBy(id = "years")
    protected WebElement year_of_birth;

    @FindBy(id = "newsletter")
    protected WebElement newsletter;

    @FindBy(id = "optin")
    protected WebElement special_offers;

    @FindBy(id = "firstname")
    protected WebElement address_firstname;

    @FindBy(id = "lastname")
    protected WebElement address_lastname;

    @FindBy(id = "company")
    protected WebElement company;

    @FindBy(id = "address1")
    protected WebElement address;

    @FindBy(id = "address2")
    protected WebElement address2;

    @FindBy(id = "city")
    protected WebElement city;

    @FindBy(id = "id_state")
    protected WebElement state;

    @FindBy(id = "postcode")
    protected WebElement zip_code;

    @FindBy(id = "id_country")
    protected WebElement country;

    @FindBy(id = "other")
    protected WebElement additional_information;

    @FindBy(id = "phone")
    protected WebElement home_number;

    @FindBy(id = "phone_mobile")
    protected WebElement phone_number;

    @FindBy(id = "alias")
    protected WebElement alias;

    @FindBy(id = "submitAccount")
    protected WebElement submitAccount;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    protected WebElement createAccountError;

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    public void selectTitle(){
        this.male_gender.click();
    }

    public void enterFirstName(){
        this.customer_firstname.clear();
        this.customer_firstname.sendKeys(FIRST_NAME);
    }

    public void enterLastName(){
        this.customer_lastname.clear();
        this.customer_lastname.sendKeys(LAST_NAME);
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
        this.address_firstname.clear();
        this.address_firstname.sendKeys(FIRST_NAME_ADDRESS);
    }

    public void enterLastNameAddress(){
        this.address_lastname.clear();
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
