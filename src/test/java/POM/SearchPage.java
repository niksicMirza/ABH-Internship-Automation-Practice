package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject {

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/h1[1]/span[1]")
    public WebElement searchHeading;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}

