package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadatak3_1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://geodata.solutions/");
        Thread.sleep(1000);

        Select selectCountry = new Select(driver.findElement(By.id("countryId")));
        selectCountry.selectByVisibleText("United States");

        Thread.sleep(1000);

        Select selectState = new Select(driver.findElement(By.id("stateId")));
        selectState.selectByVisibleText("New York");

        Thread.sleep(1000);

        Select selectCity = new Select(driver.findElement(By.id("cityId")));
        selectCity.selectByVisibleText("New York");

        Thread.sleep(5000);
        driver.quit();
    }
}