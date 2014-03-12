/**
 * Created by vanik on 05.03.14.
 */

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private  WebElement
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public MainPage enterText(String text) {
        driver.findElement(By.id("q")).sendKeys(text);
        return this;
    }

    public boolean photoIsDisplayed() {
        return new WebDriverWait(driver,5).
                until(ExpectedConditions.
                        textToBePresentInElement(driver.
                                findElement(By.id("wallpaper_toggle")), "Убрать фото"));

    }
    public MainPage displayPhoto() {
        if (!photoIsDisplayed()) driver.findElement(By.id("wallpaper_toggle")).click();
        return this;
    }
    public MainPage hidePhoto() {
//        if (photoIsDisplayed()) {
//            driver.findElement(By.id("wallpaper_toggle")).click();
//            return this;
//        }
//        else {
//            return this;
//        }
//        return this;
        if (photoIsDisplayed()) driver.findElement(By.id("wallpaper_toggle")).click();
        return this;
    }

    public List<String> suggests(String query) {
//        this.enterText(query);
        driver.findElement(By.id("q")).sendKeys(query);
        return Arrays.asList(new WebDriverWait(driver, 5, 50).until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                return input.findElement(By.id("go-suggessts"));
            }
        }).getText().split(" "));
//        return Arrays.asList((driver.
//                findElement(By.id("go-suggests")).
//                getText().split(" ")));
    }

}
