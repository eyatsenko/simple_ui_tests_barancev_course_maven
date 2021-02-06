package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YellowDuckPage {
    public YellowDuckPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String yellowDuckPageURL = "http://localhost/litecart/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1";

    @FindBy(xpath = "//div[@class = \"sticker sale\"]")
    private WebElement stickerSale;
    public WebElement getYellowDuckSticker(){
        return this.stickerSale;
    }

    public void open() {
        Driver.getDriver().get(yellowDuckPageURL);
    }
}
