package barancev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LitecartPage;
import pages.YellowDuckPage;

import java.util.concurrent.TimeUnit;

import static driver.Driver.getDriver;

public class CheckStickers {
    final Logger log = Logger.getLogger(CheckStickers.class);
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
    public void CheckStickers() throws InterruptedException {

        log.info("Open litecart page");
        litecartPage.open();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(litecartPage.getYellowDuck()));
        litecartPage.getYellowDuck().click();

        wait.until(ExpectedConditions.visibilityOf(yellowDuckPage.getYellowDuckSticker()));

        Thread.sleep(5000);
    }

    @AfterClass
    public static void TearDown() {
        if (getDriver() != null){
            getDriver().quit();
        }
    }
}
