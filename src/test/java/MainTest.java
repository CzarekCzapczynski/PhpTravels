import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class MainTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    @Parameters({"url"})
    public void before(String url) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        homePage = new HomePage(driver, url);
    }

    @AfterMethod
    public void after() {
//        driver.close();
    }
    public static String getRandomString(int length)
    {
        String randomStr = UUID.randomUUID().toString();
        while(randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, length);
    }
}
