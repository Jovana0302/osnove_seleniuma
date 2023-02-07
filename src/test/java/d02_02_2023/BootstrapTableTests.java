package d02_02_2023;

import helper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "https://s.bootsnipp.com";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test
    @Description("TC_1 Edit Row")
    public void editRow(){
        driver.get(baseUrl + "/iframe/K5yrx");

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title not as expected");

        driver.findElement(By.xpath(
                "//tbody/tr[1]//button[contains(@class,'update')]"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("edit")));

        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("fn")).sendKeys("Jovana");
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("ln")).sendKeys("Cvetanovic");
        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("mn")).sendKeys("Dragan");
        driver.findElement(By.id("up")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.id("edit")));

        Assert.assertEquals(driver.findElement(By.id("f1")).getText(),
                "Jovana",
                "First name not updated");

        Assert.assertEquals(driver.findElement(By.id("l1")).getText(),
                "Cvetanovic",
                "Last name not updated");

        Assert.assertEquals(driver.findElement(By.id("m1")).getText(),
                "Dragan",
                "Middle name not updated");
    }

    @Test
    @Description("TC_2 Delete Row")
    public void deleteRow(){
        driver.get(baseUrl + "/iframe/K5yrx");

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title not as expected");

        driver.findElement(By.xpath(
                        "//tbody/tr[1]//button[contains(@class,'delete')]"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("delete")));

        driver.findElement(By.id("del")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.id("delete")));

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(
                        "//tbody/tr[1]/td"), 0));
    }

    @Test
    @Description("TC_3 Take a Screenshot")
    public void takeScreenshot() throws IOException {
        driver.get(baseUrl + "/iframe/K5yrx");

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title not as expected");

        new Helper().takeScreenshot(driver, "screenshots/slike.png");
    }

    @AfterMethod
    public void afterMethod(){
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
