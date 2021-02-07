package barancev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LitecartPage;
import pages.YellowDuckPage;

import java.util.concurrent.TimeUnit;

import static driver.Driver.getDriver;

public class CheckRightPage {
    final Logger log = Logger.getLogger(CheckRightPage.class);
    private WebDriverWait wait= new WebDriverWait(getDriver(), 25);
    LitecartPage litecartPage = new LitecartPage();
    YellowDuckPage yellowDuckPage = new YellowDuckPage();

    @BeforeClass
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        getDriver().manage().window().maximize();
    }

    @Test
    public void CheckRightCampaign() throws InterruptedException {

        log.info("Open litecart page");
        litecartPage.open();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(litecartPage.getYellowDuck()));

        String expectedName = getDriver().findElement(By
                .xpath("//h4[@class = \"name\"]")).getText();
        String expectedRegularPrice = getDriver().findElement(By
                .xpath("//del[@class = \"regular-price\"]")).getText();
        String expectedRegularPriceTextDecoration = getDriver().findElement(By
                .xpath("//del[@class = \"regular-price\"]")).getCssValue("text-decoration");
        String expectedCampaignPrice = getDriver().findElement(By
                .xpath("//strong[@class = \"campaign-price\"]")).getText();
        String expectedCampaignFontWeight = getDriver().findElement(By
                .xpath("//strong[@class = \"campaign-price\"]")).getCssValue("font-weight");

        log.info("Open Yellow Duck page");
        litecartPage.getYellowDuck().click();

        Assert.assertEquals(expectedName, getDriver().findElement(By.xpath("//h1[@class = \"title\"]")).getText());
        Assert.assertEquals(expectedRegularPrice, getDriver().findElement(By.xpath("//del[@class = \"regular-price\"]")).getText());
        Assert.assertEquals(expectedCampaignPrice, getDriver().findElement(By.xpath("//strong[@class = \"campaign-price\"]")).getText());
        Assert.assertEquals(expectedRegularPriceTextDecoration, getDriver().findElement(By
                .xpath("//del[@class = \"regular-price\"]")).getCssValue("text-decoration"));
        Assert.assertEquals(expectedCampaignFontWeight, getDriver().findElement(By
                .xpath("//strong[@class = \"campaign-price\"]")).getCssValue("font-weight"));

        Thread.sleep(5000);
    }

    @AfterClass
    public static void TearDown() {
        if (getDriver() != null){
            getDriver().quit();
        }
    }
}
