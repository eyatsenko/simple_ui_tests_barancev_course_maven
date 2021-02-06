package barancev;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;

import static driver.Driver.getDriver;

public class CheckMenuItems {
    final Logger log = Logger.getLogger(CheckMenuItems.class);
    private WebDriver driver = new ChromeDriver();
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void clickOnEachElement() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        log.info("Open login page");
        loginPage.open();
        loginPage.login();
        wait.until(ExpectedConditions.invisibilityOf(loginPage.getLoader()));

        //wait.until(ExpectedConditions.titleIs(dashboardPage.getDashboardPageTitle()));

        log.info("Open Appearance");
        dashboardPage.getAppearance().click();
        wait.until(ExpectedConditions.titleIs(dashboardPage.getDashboardPageTitle()));

        Thread.sleep(300000);
    }

    @After
    public void TearDown() {
        while (getDriver() != null){
            getDriver().quit();
        }
    }
}
