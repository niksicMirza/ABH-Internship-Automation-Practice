import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressesPage extends PageObject{

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    protected WebElement sign_in_button;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[2]")
    protected WebElement quick_view;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]")
    protected WebElement more_button;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")
    protected WebElement add_to_cart;

    @FindBy(xpath = "//*[@alt='Printed Chiffon Dress']")
    protected WebElement image;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    protected WebElement womenCategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    protected WebElement dressesCategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
    protected WebElement summerDressesSubcategory;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    protected WebElement addToCartButton;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")
    protected WebElement proceedToCheckoutButton;

    @FindBy(id = "layered_block_left")
    protected WebElement filters;

    @FindBy(id = "selectProductSort")
    protected WebElement sort_by_dropdown;

    @FindBy(id = "best-sellers_block_right")
    protected WebElement best_sellers;

    public SummerDressesPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(){
        this.sign_in_button.click();
    }

    public void clickProceedToCheckoutButton(){
        this.proceedToCheckoutButton.click();
    }

    public void openQuickView(){
        Actions builder = new Actions(driver);
        builder.moveToElement(image).build().perform();
        this.quick_view.click();
    }

}


