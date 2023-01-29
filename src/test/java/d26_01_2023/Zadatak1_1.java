package d26_01_2023;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1_1 {
    public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");
        Thread.sleep(1000);

//        brisanje stavki koje su date kao primer kad se ucita strana
        List<WebElement> todos = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        List<WebElement> destroyButtons = driver.findElements(By.xpath("//button[@class='destroy todo-button']"));
        for (int i = todos.size()-1; i >= 0; i--) {
            Actions actions = new Actions(driver);
            actions.moveToElement(todos.get(i)).build().perform();
            actions.moveToElement(destroyButtons.get(i)).build().perform();
            destroyButtons.get(i).click();
        }

        Thread.sleep(1000);

        ArrayList<String> todo = new ArrayList<>();
        todo.add("Visit Paris");
        todo.add("Visit Prague");
        todo.add("Visit London");
        todo.add("Visit New York");
        todo.add("Visit Belgrade");

        for (int i = 0; i < todo.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(todo.get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
            try {
                driver.findElement(By.xpath("//ul[@class='todo-list']/li["+(i+1)+"]"));
                System.out.println("Dodat novi todo");
            } catch (NoSuchElementException error){
                System.out.println("Nije dodat novi todo");
            }
        }

        Thread.sleep(1000);

        todos = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        destroyButtons = driver.findElements(By.xpath("//button[@class='destroy todo-button']"));
        for (int i = todos.size()-1; i >= 0; i--) {
            Actions actions = new Actions(driver);
            actions.moveToElement(todos.get(i)).build().perform();
            actions.moveToElement(destroyButtons.get(i)).build().perform();
            destroyButtons.get(i).click();
        }

        todos = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        System.out.println("Broj todo-a na stranici: " + todos.size());

        Thread.sleep(5000);
        driver.quit();
    }
}
