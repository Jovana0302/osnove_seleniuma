package d27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        Thread.sleep(1000);

        driver.findElement(By.id("basic-primary-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-primary-example"));

        driver.findElement(By.id("basic-secondary-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-secondary-example"));

        driver.findElement(By.id("basic-success-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-success-example"));

        driver.findElement(By.id("basic-danger-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-danger-example"));

        driver.findElement(By.id("basic-warning-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-warning-example"));

        driver.findElement(By.id("basic-info-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-info-example"));

        driver.findElement(By.id("basic-light-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-light-example"));

        driver.findElement(By.id("basic-dark-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-dark-example"));

        Thread.sleep(5000);
        driver.quit();
    }
}
