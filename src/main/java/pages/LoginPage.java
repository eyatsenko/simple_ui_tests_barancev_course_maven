package pages;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String loginPageURL = "http://localhost/litecart/admin/login.php";
    private String login = "admin";
    private String password = "admin";

    @FindBy(name = "username")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class = \"loader\"]")
    private WebElement loader;

    public WebElement getLoginField(){
        return this.loginField;
    }
    public WebElement getPasswordField(){
        return this.passwordField;
    }
    public String getLogin (){
        return this.login;
    }
    public String getPassword (){
        return this.password;
    }
    public WebElement getLoader (){
        return this.loader;
    }

    public void open() {
        Driver.getDriver().get(loginPageURL);
    }

    public void login() {
        getLoginField().sendKeys(getLogin());
        getPasswordField().sendKeys(getPassword());
        getPasswordField().sendKeys(Keys.ENTER);
    }
}
