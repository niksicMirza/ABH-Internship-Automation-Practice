package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SummerDressesPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[2]")
    public WebElement quick_view;

    @FindBy(xpath = "//*[@alt='Printed Chiffon Dress']")
    public WebElement image;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")
    public WebElement proceedToCheckoutButton;

    @FindBy(id = "layered_block_left")
    public WebElement filters;

    @FindBy(id = "best-sellers_block_right")
    public WebElement best_sellers;

    public SummerDressesPage(WebDriver driver) {
        super(driver);
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


