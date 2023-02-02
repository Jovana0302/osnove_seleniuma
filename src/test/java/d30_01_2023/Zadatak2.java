package d30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://docs.katalon.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        if (driver.findElement(By.tagName("html"))
                .getAttribute("data-theme").equals("light")){
            System.out.println("Light tema");
        } else {
            System.out.println("Nije light tema");
        }

        driver.findElement(By.xpath(
                "//button[contains(@title,'Switch')]"))
                .click();

        if (driver.findElement(By.tagName("html"))
                .getAttribute("data-theme").equals("dark")){
            System.out.println("Dark tema");
        } else {
            System.out.println("Nije dark tema");
        }

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("docsearch-input")));

        if (driver.findElement(By.id("docsearch-input"))
                .getAttribute("type").equals("search")) {
            System.out.println("Search type");
        } else {
            System.out.println("Nije search type");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
