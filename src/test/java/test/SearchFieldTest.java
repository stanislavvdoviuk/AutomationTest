package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

public class SearchFieldTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        var cityToFind = "Львів";
        driver.get("https://ua.sinoptik.ua/");

        driver.findElement(By.id("search_city")).sendKeys(cityToFind);
        driver.findElement(By.cssSelector("#form-search input[type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        AssertJUnit.assertTrue(driver.getTitle().contains(cityToFind));
        driver.quit();
    }
}
