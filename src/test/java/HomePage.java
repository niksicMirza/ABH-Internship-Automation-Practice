import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    private final String SEARCH = "T-Shirt";

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    protected WebElement sign_in_button;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement sign_out_button;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[2]")
    private WebElement quick_view;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]")
    private WebElement more_button;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")
    private WebElement add_to_cart;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    private WebElement cart;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    private WebElement womenCategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement dressesCategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
    private WebElement summerDressesSubcategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    private WebElement tshirtCategory;

    @FindBy(id = "search_query_top")
    private WebElement searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openCart(){
        this.cart.click();
    }

    public void openLoginPage(){
        this.sign_in_button.click();
    }

    public void openQuickView(){
        this.quick_view.click();
    }

    public void openMoreView(){
        this.more_button.click();
    }

    public void openSummerDresses(){
        Actions builder = new Actions(driver);
        builder.moveToElement(dressesCategory).build().perform();
        this.summerDressesSubcategory.click();
    }

    public void enterSearchBarText(){
        this.searchBar.clear();
        this.searchBar.sendKeys(SEARCH);
        this.searchBar.sendKeys(Keys.ENTER);
    }

    public void singOut(){
        this.sign_out_button.click();
    }

}
