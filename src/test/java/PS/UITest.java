package PS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UITest {

    private ChromeDriver webdriver;
    private static final String ERROR_MESSAGE = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

    void fillEmail_create(String email_create) {

        webdriver.findElement(By.id("email_create")).sendKeys(email_create);
    }
    void fillCustomer_firstname(String customer_firstname)
    {
        webdriver.findElement(By.id("customer_firstname")).sendKeys(customer_firstname);
    }
    void fillCustomer_lastname(String customer_lastname)
    {
        webdriver.findElement(By.id("customer_lastname")).sendKeys(customer_lastname);
    }
    void fillPasswd(String passwd)
    {
        webdriver.findElement(By.id("passwd")).sendKeys(passwd);
    }
    void fillAddress1(String address1)
    {
        webdriver.findElement(By.id("address1")).sendKeys(address1);
    }
    void fillCity(String city)
    {
        webdriver.findElement(By.id("city")).sendKeys(city);
    }
    void fillId_state(String id_state)
    {
        Select slState = new Select( webdriver.findElement(By.id("id_state")));
        slState.selectByVisibleText(id_state);
        slState.selectByIndex(32);
    }
    void fillPostcode(String postcode)
    {
        webdriver.findElement(By.id("postcode")).sendKeys(postcode);
    }
    void fillId_country(String id_country)
    {
        Select slCountry = new Select( webdriver.findElement(By.id("id_country")));
        slCountry.selectByVisibleText(id_country);
        slCountry.selectByIndex(1);

    }
    void fillMobilePhone(String mobilePhone)
    {
        webdriver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
    }

    @BeforeClass
    public void open_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webdriver = new ChromeDriver(options);

    }

    @Test
    public void openUrlTest() {
        webdriver.get("http://automationpractice.com/");
    }

    @Test
    public void PageTitleTest() {
        webdriver.get("http://automationpractice.com/");
        String pageTitle = webdriver.getTitle();
        System.out.println("Title site : " + pageTitle);
        Assert.assertEquals(pageTitle, "My Store");
    }

@DataProvider(name = "new_user")
public Object[][] new_user()
{
    return new Object[][] {{"829aoa@gmail.com", "Stas", "Prohorov","14340dww@", "92 Nevskiy", "SPB", "New York", "43568", "United States", "+32078721240"}};
}

    @Test(dataProvider = "new_user")
    public void ex_1(String email_create, String customer_firstname, String customer_lastname, String passwd, String address1, String city, String id_state, String postcode, String id_country, String phone_mobile) throws InterruptedException {

        webdriver.get("http://automationpractice.com/");

        WebDriverWait wait = new WebDriverWait(webdriver, 60 );

        webdriver.findElement(By.cssSelector(".login")).click();

        wait.until(new PageLoaded());

        fillEmail_create(email_create);

        webdriver.findElement(By.id("SubmitCreate")).click();


        fillCustomer_firstname(customer_firstname);

        fillCustomer_lastname(customer_lastname);

        fillPasswd(passwd);

       fillAddress1(address1);

       fillCity(city);

        fillId_state(id_state);

        fillPostcode(postcode);

        fillId_country(id_country);

       fillMobilePhone(phone_mobile);

        webdriver.findElement(By.id("submitAccount")).click();
    }


    @DataProvider(name = "new_user_")
    public Object[][] new_user_()
    {
        return new Object[][] {{"829yoc@gmail.com", "Stas","14340dww@", "New York", "32567", "United States", "+21006528749"}};
    }

  @Test(dataProvider = "new_user_")
  public void ex_2 (String email_create,  String customer_lastname, String passwd,String id_state, String postcode, String id_country, String phone_mobile) throws InterruptedException {

        webdriver.get("http://automationpractice.com/");

        WebDriverWait wait = new WebDriverWait(webdriver, 60 );

        webdriver.findElement(By.cssSelector(".login")).click();

        wait.until(new PageLoaded());

        fillEmail_create(email_create);

        webdriver.findElement(By.id("SubmitCreate")).click();

        fillCustomer_lastname(customer_lastname);

        fillPasswd(passwd);

       fillId_state(id_state);

        fillPostcode(postcode);

        fillId_country(id_country);

       fillMobilePhone(phone_mobile);

        webdriver.findElement(By.id("submitAccount")).click();

    }

    @AfterClass
    public void closeBrowser(){
        webdriver.quit();
    }
}