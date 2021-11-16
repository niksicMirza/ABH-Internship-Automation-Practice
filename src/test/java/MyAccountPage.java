import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")
    protected WebElement orderHistoryAndDetails;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a")
    protected WebElement myCreditSlips;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a")
    protected WebElement myAddress;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a")
    protected WebElement myPersonalInformation;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[2]/ul/li/a")
    protected WebElement myWishlist;



    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void openOrderHistoryAndDetails(){
        this.orderHistoryAndDetails.click();
    }

    public void openMyCreditSlips(){
        this.myCreditSlips.click();
    }

    public void openMyAddress(){
        this.myAddress.click();
    }

    public void openMyPersonalInformation(){
        this.myPersonalInformation.click();
    }

    public void openMyWishlist(){
        this.myWishlist.click();
    }
}

