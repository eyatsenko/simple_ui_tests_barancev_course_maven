package barancev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static driver.Driver.getDriver;

public class CheckStickers {
    final Logger log = Logger.getLogger(CheckMenuItems.class);
    private WebDriverWait wait= new WebDriverWait(getDriver(), 25);
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @BeforeClass
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        getDriver().manage().window().maximize();
    }

    @Test
    public void clickOnEachElement() throws InterruptedException {

        log.info("Open login page");
        loginPage.open();
        loginPage.login();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getAppearance()));
        wait.until(ExpectedConditions.titleIs(dashboardPage.getDashboardPageTitle()));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.getAppearance()));

        log.info("Open Appearance");
        dashboardPage.getAppearance().click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getTemplate()));
        wait.until(ExpectedConditions.titleIs(dashboardPage.getAppearancePageTitle()));

        log.info("Click on Template");
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getTemplate()));
        dashboardPage.getTemplate().click();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getTemplate()));
        wait.until(ExpectedConditions.titleIs(dashboardPage.getAppearancePageTitle()));

        log.info("Click on Logotype");
        dashboardPage.getLogotype().click();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getTemplate()));
        wait.until(ExpectedConditions.titleIs(dashboardPage.getLogotypePageTitle()));

        Thread.sleep(5000);
    }

    @AfterClass
    public static void TearDown() {
        if (getDriver() != null){
            getDriver().quit();
        }
    }
}
