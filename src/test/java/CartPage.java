import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends PageObject{

    @FindBy(id = "cart_summary")
    protected WebElement cart_summary_box;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]")
    protected WebElement check_payment_box;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]")
    protected WebElement box_order_confirmation;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[2]")
    protected WebElement plus_button;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/input[2]")
    protected WebElement quantity_box;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/h1[1]")
    protected WebElement carts_headings;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/h1[1]")
    protected WebElement carts_headings_shipping;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]")
    protected WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]")
    protected WebElement proceedToCheckoutButtonAddresses;

    @FindBy(name = "processCarrier")
    protected WebElement proceedToCheckoutButtonShipping;

    @FindBy(id = "id_address_delivery")
    protected WebElement deliveryAddressDropdown;

    @FindBy(id = "address_delivery")
    protected WebElement address_delivery_box;

    @FindBy(id = "address_invoice")
    protected WebElement billing_address_box;

    @FindBy(id = "addressesAreEquals")
    protected WebElement addressesEqualCheckbox;

    @FindBy(id = "cgv")
    protected WebElement termsOfServiceCheck;

    @FindBy(xpath = "//*[@title='Pay by check.']")
    protected WebElement payByCheckOption;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    protected WebElement confirmOrderButton;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/a[1]")
    protected WebElement icon_trash;

    @FindBy(id = "order_step")
    protected WebElement order_steps;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlusButton(){
        this.plus_button.click();
    }

    public void clickProceedToCheckoutButton(){
        this.proceedToCheckoutButton.click();
    }

    public void selectDeliveryAddress(){
        Select deliveryAddress = new Select(deliveryAddressDropdown);
        deliveryAddress.getFirstSelectedOption();
    }

    public void clickOnEqualAddressesCheckbox(){
        this.addressesEqualCheckbox.click();
    }

    public void checkTermsOfService(){
        this.termsOfServiceCheck.click();
    }

    public void clickOnPayByCheck(){
        this.payByCheckOption.click();
    }

    public void clickOnConfirmOrderButton(){
        this.confirmOrderButton.click();
    }

    public void clickProceedToCheckoutButtonAddresses(){
        this.proceedToCheckoutButtonAddresses.click();
    }

    public void clickProceedToCheckoutButtonShipping(){
        this.proceedToCheckoutButtonShipping.click();
    }








}