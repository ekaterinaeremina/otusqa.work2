package otusqa;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.aeonbits.owner.ConfigFactory;

//@Listeners(ExecutionListener.class)
public class OtusSiteTest {

    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(OtusSiteTest.class);
    private static MyConfig config = ConfigFactory.create(MyConfig.class);
    protected static String browser = System.getProperty("browser").toUpperCase();

    @BeforeClass
    public static void setUp()
    {
        driver = WebDriverFactory.create(WebDriverName.valueOf(browser));
        log.info("Setup driver");
    }

    @Test (description = "")
    public void verifyMainPageURLTest()
    {
        log.info("Run verifyMainPageURLTest");
        String otus_url = config.url();
        driver.get(otus_url);
        log.info("Go to " + otus_url);
        Assert.assertEquals(driver.getCurrentUrl(), config.url());
        log.info("Passed verifyMainPageURLTest!");
    }

    @AfterClass
    public static void tearDown()
    {
        if (driver!=null) {
            driver.quit();
            driver = null;
        }
    }
}