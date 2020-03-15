package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

public class TenDaysWeatherTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        int tenDaysBlock=10;
        driver.get("https://ua.sinoptik.ua/");
        driver.findElement(By.cssSelector("#topMenu :nth-child(2)")).click();
        Thread.sleep(3000);
        var showedDays = driver.findElements(By.cssSelector("#blockDays .main"));
        AssertJUnit.assertEquals(tenDaysBlock,showedDays.size());
        driver.close();
    }
}
