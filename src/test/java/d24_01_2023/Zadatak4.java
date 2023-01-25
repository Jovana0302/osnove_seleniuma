package d24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://artplayer.org/");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//i[@aria-label='Play']")).click();
        driver.findElement(By.xpath("//i[@aria-label='Mute']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//i[contains(@class,'screenshot')]")).click();
        driver.findElement(By.xpath("//i[contains(@class,'pip')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//i[contains(@class,'pip')]")).click();
        driver.findElement(By.xpath("//i[contains(@class,'fullscreenWebOn')]")).click();
        driver.findElement(By.xpath("//i[contains(@class,'fullscreenWebOff')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
