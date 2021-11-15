import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class QuickViewPage extends PageObject{

    protected final String SIZE = "2";

    @FindBy(xpath = "//body/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/p[1]/a[2]")
    protected WebElement plus_button;

    @FindBy(xpath = "//*[@id=\"group_1\"]")
    protected WebElement size_dropdown;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    protected WebElement add_to_cart;

    @FindBy(id = "quantity_wanted")
    protected WebElement quantityBox;

    public QuickViewPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlusButton(){
        this.plus_button.click();
    }

    public void selectSize() {
        Select sizeDropdown = new Select(size_dropdown);
        sizeDropdown.selectByValue(SIZE);
    }
    public void clickAddToCartButton(){
        this.add_to_cart.click();
    }

}

