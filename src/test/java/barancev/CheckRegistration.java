package barancev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateAccountPage;
import pages.LitecartPage;

import java.util.concurrent.TimeUnit;

import static driver.Driver.getDriver;

public class CheckRegistration {
    final Logger log = Logger.getLogger(CheckStickers.class);
    private WebDriverWait wait= new WebDriverWait(getDriver(), 25);
    LitecartPage litecartPage = new LitecartPage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @BeforeClass
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        getDriver().manage().window().maximize();
    }

    @Test
    public void checkRegistration() throws InterruptedException {

        log.info("Open litecart page");
        litecartPage.open();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(litecartPage.getSignInButton()));

        log.info("Open Sign In modal");
        litecartPage.getSignInButton().click();
        wait.until(ExpectedConditions.visibilityOf(litecartPage.getLinkForNewUsers()));

        log.info("Open Create Account page");
        litecartPage.getLinkForNewUsers().click();

        wait.until(ExpectedConditions.titleIs(litecartPage.getCreateAccountPageTitle()));

        log.info("Send first Name");
        wait.until(ExpectedConditions.visibilityOf(createAccountPage.getFirsName()));
        createAccountPage.getFirsName().click();
        createAccountPage.getFirsName().sendKeys("testFirstName1");

        log.info("Send last Name");
        createAccountPage.getLastName().sendKeys("testLastName1");

        log.info("Select country");
        createAccountPage.getCountrySelect().selectByValue("US");

        log.info("Select zone code");
        createAccountPage.getZoneCode().selectByIndex(1);

        log.info("Send email");
        createAccountPage.getEmail().sendKeys("test1@test.com");

        log.info("Send password");
        createAccountPage.getPassword().sendKeys("12345Qwerty!");

        log.info("Send confirmed password");
        createAccountPage.getConfirmedPassword().sendKeys("12345Qwerty!");

        log.info("Select terms");
        createAccountPage.getTermsAgreed().click();

        Thread.sleep(5000);
    }

    @AfterClass
    public static void TearDown() {
        if (getDriver() != null){
            getDriver().quit();
        }
    }
}
