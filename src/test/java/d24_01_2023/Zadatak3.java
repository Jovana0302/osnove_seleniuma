package d24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//button[contains(@class,'add-new')]")).click();
            driver.findElement(By.name("name")).sendKeys("NN");
            driver.findElement(By.name("department")).sendKeys("Sales");
            driver.findElement(By.name("phone")).sendKeys("(555) 555-5555");
            driver.findElement(By.xpath("//tr[last()]//a[@class='add']/i")).click();
            Thread.sleep(500);
        }

        driver.quit();
    }
}
