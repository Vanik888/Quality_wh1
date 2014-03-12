import com.sun.glass.ui.View;
import net.lightbody.bmp.proxy.ProxyServer;
import org.eclipse.jetty.util.thread.Timeout;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by vanik on 05.03.14.
 */
public class SimpleTests {
    private WebDriver driver;
    private ProxyServer proxy;
//public class SimpleTest() {
//
//    }
    @BeforeMethod
    public void setUp() throws  Exception{
        driver = new FirefoxDriver();
        driver.navigate().to("http://go.mail.ru/");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        proxy = new ProxyServer();
        proxy.start();
        proxy.seleniumProxy();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy.seleniumProxy());
        driver = new FirefoxDriver(capabilities);

    }
    public void testPhotoDisplayed() {
//        String title = new MainPage(driver).enterText("Путин")
//        MainPage mainPage = new MainPage(driver);
//        mainPage.hidePhoto();
//        mainPage.photo
        Assert.assertFalse(new MainPage(driver));

    }
//    @Test
//    public void testSuggests() {
//        Assert.assertTrue(new MainPage(driver));
//    }
    @Test
    public void testResultTitle() {
        String title = new
    }
    @AfterMethod
    public void tearDown() {
        proxy.stop();
    }

}
