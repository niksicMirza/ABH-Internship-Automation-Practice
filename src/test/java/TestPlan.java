import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeTest
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Smoke test")
    public static void smokeTest() throws IOException {

        driver.get(Utils.HOME_PAGE_URL);
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        SummerDressesPage summerDressesPage = new SummerDressesPage(driver);
        QuickViewPage quickViewPage = new QuickViewPage(driver);
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        CartPage cartPage = new CartPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        GenerateCredentials generateCredentials = new GenerateCredentials();

        //check the title
        assertEquals(Utils.HOME_PAGE_TITLE, driver.getTitle());
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //check the title
        assertEquals(Utils.LOGIN_PAGE_TITLE, driver.getTitle());
        loginPage.enterCreateEmailAddress();
        loginPage.pressCreateButton();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //check the title
        assertEquals(Utils.CREATE_AN_ACCOUNT_PAGE_TITLE, driver.getTitle());
        createAnAccountPage.selectTitle();
        assertTrue(createAnAccountPage.male_gender.isSelected());
        createAnAccountPage.enterFirstName();
        assertTrue(!createAnAccountPage.customer_firstname.getAttribute("value").isEmpty());
        createAnAccountPage.enterLastName();
        assertTrue(!createAnAccountPage.customer_lastname.getAttribute("value").isEmpty());
        createAnAccountPage.enterPassword();
        assertTrue(!createAnAccountPage.passwd.getAttribute("value").isEmpty());
        generateCredentials.enterCredentialsInTxtFile(loginPage.CREATE_AN_ACCOUNT_EMAIL, createAnAccountPage.ENCODED_PASSWORD);
        createAnAccountPage.enterDayOfBirth();
        assertEquals(createAnAccountPage.DAY_OF_BIRTH, createAnAccountPage.day_of_birth.getAttribute("value"));
        createAnAccountPage.enterMonthOfBirth();
        assertEquals(createAnAccountPage.MONTH_OF_BIRTH, createAnAccountPage.month_of_birth.getAttribute("value"));
        createAnAccountPage.enterYearOfBirth();
        assertEquals(createAnAccountPage.YEAR_OF_BIRTH, createAnAccountPage.year_of_birth.getAttribute("value"));
        createAnAccountPage.enterFirstNameAddress();
        assertTrue(!createAnAccountPage.address_firstname.getAttribute("value").isEmpty());
        createAnAccountPage.enterLastNameAddress();
        assertTrue(!createAnAccountPage.address_lastname.getAttribute("value").isEmpty());
        createAnAccountPage.enterCompany();
        assertTrue(!createAnAccountPage.company.getAttribute("value").isEmpty());
        createAnAccountPage.enterAddress();
        assertTrue(!createAnAccountPage.address.getAttribute("value").isEmpty());
        createAnAccountPage.enterAddress2();
        assertTrue(!createAnAccountPage.address2.getAttribute("value").isEmpty());
        createAnAccountPage.enterCity();
        assertTrue(!createAnAccountPage.city.getAttribute("value").isEmpty());
        createAnAccountPage.selectState();
        assertEquals(createAnAccountPage.STATE_VALUE, createAnAccountPage.state.getAttribute("value"));
        createAnAccountPage.enterZipCode();
        assertTrue(!createAnAccountPage.zip_code.getAttribute("value").isEmpty());
        createAnAccountPage.selectCountry();
        assertEquals(createAnAccountPage.COUNTRY_VALUE, createAnAccountPage.country.getAttribute("value"));
        createAnAccountPage.enterAdditionalInformation();
        assertTrue(!createAnAccountPage.additional_information.getAttribute("value").isEmpty());
        createAnAccountPage.enterHomeNumber();
        assertTrue(!createAnAccountPage.home_number.getAttribute("value").isEmpty());
        createAnAccountPage.enterMobileNumber();
        assertTrue(!createAnAccountPage.phone_number.getAttribute("value").isEmpty());
        createAnAccountPage.enterAddressAlias();
        assertTrue(!createAnAccountPage.alias.getAttribute("value").isEmpty());
        createAnAccountPage.pressRegisterButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the title
        assertEquals(Utils.MY_ACCOUNT_PAGE_TITLE, driver.getTitle());
        myAccountPage.clickOnLogo();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the title
        assertEquals(Utils.HOME_PAGE_TITLE, driver.getTitle());
        homePage.openSummerDresses();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the title
        assertEquals(Utils.SUMMER_DRESSES_TITLE, driver.getTitle());
        summerDressesPage.openQuickView();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.switchTo().frame(0);
        quickViewPage.clickPlusButton();
        assertEquals("2", quickViewPage.quantityBox.getAttribute("value"));
        quickViewPage.selectSize();
        assertEquals(quickViewPage.SIZE, quickViewPage.size_dropdown.getAttribute("value"));
        //assertTrue(quickViewPage.size_dropdown.isSelected());
        quickViewPage.clickAddToCartButton();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.switchTo().defaultContent();
        summerDressesPage.clickProceedToCheckoutButton();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        cartPage.clickPlusButton();
        cartPage.clickProceedToCheckoutButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //check the heading
        assertEquals(Utils.ADDRESSES_CART_PAGE_HEADING, cartPage.carts_headings.getText());

        cartPage.selectDeliveryAddress();
        if(!cartPage.addressesEqualCheckbox.isSelected()){   //check if the checkbox is not checked
            cartPage.clickOnEqualAddressesCheckbox();
        }
        cartPage.clickProceedToCheckoutButtonAddresses();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the heading
        assertEquals(Utils.SHIPPING_CART_PAGE_HEADING, cartPage.carts_headings_shipping.getText());

        if(!cartPage.termsOfServiceCheck.isSelected()){  //check if the checkbox is not checked
            cartPage.checkTermsOfService();
        }
        cartPage.clickProceedToCheckoutButtonShipping();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the heading
        assertEquals(Utils.PAYMENT_CART_PAGE_HEADING, cartPage.carts_headings.getText());

        cartPage.clickOnPayByCheck();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the heading
        assertEquals(Utils.ORDER_SUMMARY_CART_PAGE_HEADING, cartPage.carts_headings.getText());

        cartPage.clickOnConfirmOrderButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the heading
        assertEquals(Utils.ORDER_CONFIRMATION_CART_PAGE_HEADING, cartPage.carts_headings.getText());

        myAccountPage.clickOnLogo();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the title
        assertEquals(Utils.HOME_PAGE_TITLE, driver.getTitle());

        homePage.enterSearchBarText();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check the heading
        assertEquals("\"T-SHIRT\"", searchPage.searchHeading.getText());

        homePage.singOut();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //check if the sign in button is displayed
        assertEquals(true, homePage.sign_in_button.isDisplayed());
    }

    @AfterTest
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}