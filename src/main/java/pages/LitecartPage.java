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
    private String createAccountPageTitle = "Create Account | My Store";
    public String getCreateAccountPageTitle(){
        return this.createAccountPageTitle;
    }

    @FindBy(xpath = "//img[@alt = \"Yellow Duck\"]")
    private WebElement yellowDuck;
    public WebElement getYellowDuck(){
        return this.yellowDuck;
    }

    @FindBy(xpath = "//section[@id = \"box-campaign-products\"]")
    private WebElement capmpaignSection;
    public WebElement getCapmpaignSection(){
        return this.capmpaignSection;
    }

    @FindBy(xpath = "//li[@class = \"account dropdown\"]")
    private WebElement signInButton;
    public WebElement getSignInButton(){
        return this.signInButton;
    }

    @FindBy(xpath = "//a[@href = \"http://localhost/litecart/create_account\"]")
    private WebElement linkForNewUsers;
    public WebElement getLinkForNewUsers(){
        return this.linkForNewUsers;
    }


    public void open() {
        Driver.getDriver().get(litecartPageURL);
    }
}
