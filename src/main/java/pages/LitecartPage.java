package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LitecartPage {
    public LitecartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String loginPageURL = "http://localhost/litecart/";

    @FindBy(xpath = "//img[@alt = \"Yellow Duck\"]")
    private WebElement yellowDuck;

    public WebElement getYellowDuck(){
        return this.yellowDuck;
    }
}
