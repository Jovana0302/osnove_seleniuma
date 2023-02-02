package d31_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        new Actions(driver).scrollToElement(driver.findElement(By.xpath(
                "//*[contains(@class,'slider_bkgd')]")))
                .perform();

        List<WebElement> linkovi = driver.findElements(By.xpath(
                "//*[contains(@class,'slider_bkgd')]//img"));

        for (int i = 0; i < linkovi.size(); i++) {
            String url = linkovi.get(i).getAttribute("src");
            try {
            int statusCode = new Helper().getHTTPResponseStatusCode(url);
                if (statusCode >= 200 && statusCode < 300) {
                    try {
                        new Helper().downloadUsingStream(url,
                                "itbootcamp_slider/slika["+(i+1)+"].png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
