package POM;
import data.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends PageObject{

    GenerateCredentials generateCredentials = new GenerateCredentials();


    public final String FIRST_NAME = "Tester";
    public final String LAST_NAME = "Tester";
    public final String ENCODED_PASSWORD = generateCredentials.encodePassword(GenerateCredentials.passwordGenerator());
    public final String PASSWORD = generateCredentials.decodePassword(ENCODED_PASSWORD);
    public final String DAY_OF_BIRTH = "14";
    public final String MONTH_OF_BIRTH = "10";
    public final String YEAR_OF_BIRTH = "1983";
    public final String FIRST_NAME_ADDRESS = "Tester";
    public final String LAST_NAME_ADDRESS = "Tester";
    public final String COMPANY = "Atlantbh";
    public final String ADDRESS = "Ruzevik 22";
    public final String CITY = "Sarajevo";
    public final String STATE = "Alabama";
    public final String STATE_VALUE = "1";
    public final String ZIP = "71251";
    public final String COUNTRY = "United States";
    public final String COUNTRY_VALUE = "21";
    public final String ADDITIONAL_INFORMATION = "Nulla quis lorem ut libero malesuada feugiat.";
    public final String MOBILE_NUMBER = "0636587";
    public final String HOME_NUMBER = "0335964";
    public final String ADDRESS_ALIAS = "My address";


    @FindBy(id = "id_gender1")
    public WebElement male_gender;

    @FindBy(id = "id_gender2")
    public WebElement female_gender;

    @FindBy(id = "customer_firstname")
    public WebElement customer_firstname;

    @FindBy(id = "customer_lastname")
    public WebElement customer_lastname;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement passwd;

    @FindBy(id = "days")
    public WebElement day_of_birth;

    @FindBy(id = "months")
    public WebElement month_of_birth;

    @FindBy(id = "years")
    public WebElement year_of_birth;

    @FindBy(id = "newsletter")
    public WebElement newsletter;

    @FindBy(id = "optin")
    public WebElement special_offers;

    @FindBy(id = "firstname")
    public WebElement address_firstname;

    @FindBy(id = "lastname")
    public WebElement address_lastname;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "address2")
    public WebElement address2;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement state;

    @FindBy(id = "postcode")
    public WebElement zip_code;

    @FindBy(id = "id_country")
    public WebElement country;

    @FindBy(id = "other")
    public WebElement additional_information;

    @FindBy(id = "phone")
    public WebElement home_number;

    @FindBy(id = "phone_mobile")
    public WebElement phone_number;

    @FindBy(id = "alias")
    public WebElement alias;

    @FindBy(id = "submitAccount")
    public WebElement submitAccount;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    public WebElement createAccountError;

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

