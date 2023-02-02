package d30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        Thread.sleep(1000);

        Select selectDelay = new Select(driver.findElement(By.id("delay-select")));
        selectDelay.selectByVisibleText("2000ms");

        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("infinite-scroll-button")))
                .perform();

        new Actions(driver)
                .scrollToElement(driver.findElement(By.xpath(
                        "//*[@class='item'][4]")))
                .perform();

        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("infinite-scroll-button")))
                .perform();

        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.id("infinite-scroll-button"))));

        driver.findElement(By.id("infinite-scroll-button")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(
                (By.className("item")), 8));

        wait.until(ExpectedConditions
                .not(ExpectedConditions.elementToBeClickable
                        (By.id("infinite-scroll-button"))));

        Thread.sleep(5000);
        driver.quit();
    }
}
