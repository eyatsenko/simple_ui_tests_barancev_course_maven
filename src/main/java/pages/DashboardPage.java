package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String loginPageURL = "http://localhost/litecart/admin/";
    private String dashboardPageTitle = "Dashboard | My Store";
    private String appearancePageTitle = "Template | My Store";
    private String logotypePageTitle = "Logotype | My Store";
    private String catalogPageTitle = "Catalog | My Store";
    private String countriesPageTitle = "Countries | My Store";
    private String currenciesPageTitle = "Currencies | My Store";
    private String customersPageTitle = "Customers | My Store";
    private String geoZonesPageTitle = "Geo Zones | My Store";
    private String languagesPageTitle = "Languages | My Store";
    private String modulesPageTitle = "Customer Modules | My Store";
    private String ordersPageTitle = "Orders | My Store";
    private String pagesPageTitle = "Pages | My Store";
    private String reportsPageTitle = "Monthly Sales | My Store";
    private String settingsPageTitle = "Settings | My Store";
    private String slidesPageTitle = "Slides | My Store";
    private String taxRatesPageTitle = "Tax Rates | My Store";
    private String translationsPageTitle = "Search Translations | My Store";
    private String usersPageTitle = "Users | My Store";
    private String vQmodsPageTitle = "vQmods | My Store";

    @FindBy(xpath = "//li[@data-code=\"appearance\"]")
    private WebElement appearance;
    @FindBy(xpath = "//li[@data-code=\"template\"]")
    private WebElement template;
    @FindBy(xpath = "//li[@data-code=\"logotype\"]")
    private WebElement logotype;
    @FindBy(xpath = "//li[@data-code=\"catalog\"]")
    private WebElement catalog;
    @FindBy(xpath = "//li[@data-code=\"countries\"]")
    private WebElement countries;
    @FindBy(xpath = "//li[@data-code=\"currencies\"]")
    private WebElement currencies;
    @FindBy(xpath = "//li[@data-code=\"customers\"]")
    private WebElement customers;
    @FindBy(xpath = "//li[@data-code=\"geo_zones\"]")
    private WebElement geo_zones;
    @FindBy(xpath = "//li[@data-code=\"languages\"]")
    private WebElement languages;
    @FindBy(xpath = "//li[@data-code=\"modules\"]")
    private WebElement modules;
    @FindBy(xpath = "//li[@data-code=\"orders\"]")
    private WebElement orders;
    @FindBy(xpath = "//li[@data-code=\"pages\"]")
    private WebElement pages;
    @FindBy(xpath = "//li[@data-code=\"reports\"]")
    private WebElement reports;
    @FindBy(xpath = "//li[@data-code=\"settings\"]")
    private WebElement settings;
    @FindBy(xpath = "//li[@data-code=\"slides\"]")
    private WebElement slides;
    @FindBy(xpath = "//li[@data-code=\"tax\"]")
    private WebElement tax;
    @FindBy(xpath = "//li[@data-code=\"translations\"]")
    private WebElement translations;
    @FindBy(xpath = "//li[@data-code=\"users\"]")
    private WebElement users;
    @FindBy(xpath = "//li[@data-code=\"vqmods\"]")
    private WebElement vqmods;

    public WebElement getAppearance(){
        return this.appearance;
    }
    public WebElement getTemplate(){
        return this.template;
    }
    public WebElement getLogotype(){
        return this.logotype;
    }
    public WebElement getCatalog(){
        return this.catalog;
    }
    public WebElement getCountries(){
        return this.countries;
    }
    public WebElement getCurrencies(){
        return this.currencies;
    }
    public WebElement getCustomers(){
        return this.customers;
    }
    public WebElement getGeo_zones(){
        return this.geo_zones;
    }
    public WebElement getLanguages(){
        return this.languages;
    }
    public WebElement getModules(){
        return this.modules;
    }
    public WebElement getOrders(){
        return this.orders;
    }
    public WebElement getPages(){
        return this.pages;
    }
    public WebElement getReports(){
        return this.reports;
    }
    public WebElement getSettings(){
        return this.settings;
    }
    public WebElement getSlides(){
        return this.slides;
    }
    public WebElement getTax(){
        return this.tax;
    }
    public WebElement getTranslations(){
        return this.translations;
    }
    public WebElement getUsers(){
        return this.users;
    }
    public WebElement getVqmods(){
        return this.vqmods;
    }

    public String getDashboardPageTitle(){
        return this.dashboardPageTitle;
    }
    public String getAppearancePageTitle(){
        return this.appearancePageTitle;
    }
    public String getLogotypePageTitle(){
        return this.logotypePageTitle;
    }

    public DashboardPage open() {
        Driver.getDriver().get(loginPageURL);
        return new DashboardPage();
    }
}
