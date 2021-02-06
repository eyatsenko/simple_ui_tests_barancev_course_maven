package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LitecartPage {
    public LitecartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String litecartPageURL = "http://localhost/litecart/";

    @FindBy(xpath = "//img[@alt = \"Yellow Duck\"]")
    private WebElement yellowDuck;

    public WebElement getYellowDuck(){
        return this.yellowDuck;
    }

    public void open() {
        Driver.getDriver().get(litecartPageURL);
    }
}
