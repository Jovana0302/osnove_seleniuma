package d31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.className("edit-image")).click();
        driver.findElement(By.id("image-option-remove")).click();

        driver.findElement(By.className("edit-image")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='root']/div/div")));

        driver.findElement(By.id("imageUpload"))
                .sendKeys(new File("test_data/front.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(
                "//*[@class='sc-dIfARi usMKB']//img"), 1));

        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//button[text()='Done']")).click();

        Thread.sleep(2000);

        driver.findElement(By.className("edit-image")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='root']/div/div")));

        driver.findElement(By.id("imageUpload"))
                .sendKeys(new File("test_data/right.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(
                "//*[@class='sc-dIfARi usMKB']//img"), 2));

        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//button[text()='Done']")).click();

        Thread.sleep(2000);

        driver.findElement(By.className("edit-image")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='root']/div/div")));

        driver.findElement(By.id("imageUpload"))
                .sendKeys(new File("test_data/left.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(
                "//*[@class='sc-dIfARi usMKB']//img"), 3));

        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//button[text()='Done']")).click();

        Thread.sleep(2000);

        driver.findElement(By.className("edit-image")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='root']/div/div")));

        driver.findElement(By.id("imageUpload"))
                .sendKeys(new File("test_data/back.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(
                "//*[@class='sc-dIfARi usMKB']//img"), 4));

        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//button[text()='Done']")).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("textareaID")).sendKeys("Love");
        driver.findElement(By.id("text-editor-done")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
