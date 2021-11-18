package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    private final String SEARCH = "T-Shirt";

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
    public WebElement logo;

    @FindBy(id = "block_top_menu")
    public WebElement top_menu;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    public WebElement sign_in_button;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    public WebElement sign_out_button;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[2]")
    public WebElement quick_view;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]")
    public WebElement more_button;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")
    public WebElement add_to_cart;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    public WebElement cart;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    public WebElement womenCategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    public WebElement dressesCategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
    public WebElement summerDressesSubcategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    public WebElement tshirtCategory;

    @FindBy(id = "search_query_top")
    public WebElement searchBar;

    @FindBy(id = "footer")
    public WebElement footer;

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

    public void clickOnLogo(){
        this.logo.click();
    }

}
