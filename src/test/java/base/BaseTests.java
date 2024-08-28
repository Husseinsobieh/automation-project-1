package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {
    private WebDriver driver;

    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

//        driver.manage().window().setSize(new Dimension(400, 900));
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
//        WebElement inputsLink = driver.findElement(By.cssSelector("li a[href *= \"inputs\"]"));
//        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for(var link:links){
            System.out.println(link.getText());
        }
//        inputsLink.click();
//        try{
//            Thread.sleep(2000);
//        } catch (InterruptedException e){
//            System.out.println(e);
//        }
        driver.quit();
    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setup();
    }
}
