package d31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(
                        "//li[@id='menu-item-6408']/a")))
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//li[@id='menu-item-6408']//ul")));

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(
                        "//li[@id='menu-item-5362']/a")))
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//li[@id='menu-item-5362']//ul")));

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(
                        "//li[@id='menu-item-5453']/a")))
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//li[@id='menu-item-5453']//ul")));

        Thread.sleep(5000);
        driver.quit();
    }
}
