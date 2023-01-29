package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        Thread.sleep(1000);

        List<WebElement> buttons = driver.findElements(By.xpath(
                "//div[contains(@class,'alert')]/button"));

        for (int i = buttons.size()-1; i >= 0; i--) {
            buttons.get(i).click();
            Thread.sleep(1000);
            try {
                driver.findElement(By.xpath(
                        "////div[contains(@class,'alert')]["+i+"]"));
                System.out.println("Alert se nije obrisao");
            } catch (NoSuchElementException error){
                System.out.println("Alert se obrisao");
            }
        }

        driver.quit();
    }
}
