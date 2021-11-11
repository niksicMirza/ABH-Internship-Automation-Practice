
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;


public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeTest
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Smoke test")
    public static void smokeTest(){
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
        createAnAccountPage.enterFirstName();
        createAnAccountPage.enterLastName();
        //createAnAccountPage.enterEmailAddress();
        createAnAccountPage.enterPassword();
        createAnAccountPage.enterDayOfBirth();
        createAnAccountPage.enterMonthOfBirth();
        createAnAccountPage.enterYearOfBirth();
        createAnAccountPage.enterFirstNameAddress();
        createAnAccountPage.enterLastNameAddress();
        createAnAccountPage.enterCompany();
        createAnAccountPage.enterAddress();
        createAnAccountPage.enterAddress2();
        createAnAccountPage.enterCity();
        createAnAccountPage.selectState();
        createAnAccountPage.enterZipCode();
        createAnAccountPage.selectCountry();
        createAnAccountPage.enterAdditionalInformation();
        createAnAccountPage.enterHomeNumber();
        createAnAccountPage.enterMobileNumber();
        createAnAccountPage.enterAddressAlias();
        createAnAccountPage.pressRegisterButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
        quickViewPage.selectSize();
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
        if(!cartPage.addressesEqualCheckbox.isSelected()){
            cartPage.clickOnEqualAddressesCheckbox();
        }
        cartPage.clickProceedToCheckoutButtonAddresses();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //check the heading
        assertEquals(Utils.SHIPPING_CART_PAGE_HEADING, cartPage.carts_headings_shipping.getText());

        cartPage.checkTermsOfService();
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
        assertEquals("T-Shirt", searchPage.searchHeading.getText());

        homePage.singOut();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //check if the sign in button is displayed
        assertEquals(true, homePage.sign_in_button.isDisplayed());
    }

    @Test
    public static void test() throws InterruptedException {
        driver.get(Utils.SUMMER_DRESSES_URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        SummerDressesPage summerDressesPage = new SummerDressesPage(driver);
        QuickViewPage quickViewPage = new QuickViewPage(driver);
        CartPage cartPage = new CartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        summerDressesPage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.enterEmailAddress();
        loginPage.enterPassword();
        loginPage.pressLoginButton();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(Utils.SUMMER_DRESSES_URL);
        summerDressesPage.openQuickView();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
        quickViewPage.clickPlusButton();
        quickViewPage.selectSize();
        quickViewPage.clickAddToCartButton();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
        System.out.print(driver.getTitle());

        summerDressesPage.clickProceedToCheckoutButton();
        Thread.sleep(5000);

        cartPage.clickPlusButton();
        cartPage.clickProceedToCheckoutButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //check the heading
        assertEquals(Utils.ADDRESSES_CART_PAGE_HEADING, cartPage.carts_headings.getText());

        cartPage.selectDeliveryAddress();
        if(!cartPage.addressesEqualCheckbox.isSelected()){
            cartPage.clickOnEqualAddressesCheckbox();
        }
        cartPage.clickProceedToCheckoutButtonAddresses();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        //check the heading
        assertEquals(Utils.SHIPPING_CART_PAGE_HEADING, cartPage.carts_headings_shipping.getText());

        cartPage.checkTermsOfService();
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
        assertEquals("T-Shit", searchPage.searchHeading.getText());

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