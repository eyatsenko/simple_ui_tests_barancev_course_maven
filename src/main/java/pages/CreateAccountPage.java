package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
    public static final String createAccountPageURL = "http://localhost/litecart/create_account";

    @FindBy(xpath = "//input[@name=\"firstname\"]")
    private WebElement firsName;
    public WebElement getFirsName(){
        return this.firsName;
    }

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    private WebElement lastName;
    public WebElement getLastName(){
        return this.lastName;
    }

    @FindBy(xpath = "//select[@name=\"country_code\"]")
    private Select countrySelect;
    public Select getCountrySelect(){
        return this.countrySelect;
    }

    @FindBy(xpath = "//select[@name=\"zone_code\"]")
    private Select zoneCode;
    public Select getZoneCode(){
        return this.zoneCode;
    }

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement email;
    public WebElement getEmail(){
        return this.email;
    }

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement password;
    public WebElement getPassword(){
        return this.password;
    }

    @FindBy(xpath = "//input[@name=\"confirmed_password\"]")
    private WebElement confirmedPassword;
    public WebElement getConfirmedPassword(){
        return this.confirmedPassword;
    }

    @FindBy(xpath = "//input[@name=\"terms_agreed\"]")
    private WebElement termsAgreed;
    public WebElement getTermsAgreed(){
        return this.termsAgreed;
    }

    public CreateAccountPage open() {
        Driver.getDriver().get(createAccountPageURL);
        return new CreateAccountPage();
    }
}
