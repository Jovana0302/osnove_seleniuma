package d27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak1_27_01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        Thread.sleep(1000);

        List<WebElement> buttons = driver.findElements(By.xpath(
                "//*[@class='container text-center']" +
                        "[not(@id='stacking-container')]/button"));

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();
            try{
                driver.findElement(By.xpath(
                        "//*[@role='alert']" +
                                "[contains(@class,'toast-fixed')]" +
                                "[contains(@class,'fade')]" +
                                "["+(i+1)+"]"));
                System.out.println("Pojavio se toast");
            } catch (NoSuchElementException error){
                System.out.println("Nije se pojavio toast");
            }
            Thread.sleep(1000);
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
