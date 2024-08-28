package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ScenarioTests {
    private WebDriver driver;

    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

//        driver.manage().window().setSize(new Dimension(400, 900));
        driver.manage().window().maximize();
        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();
        WebElement menu = driver.findElement(By.cssSelector("div a[href*=\"menu\"]"));
        menu.click();
        List<WebElement> links = driver.findElements(By.cssSelector(".example ul li"));
        System.out.println(links.size());
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println(e);
        }
        driver.quit();
    }

    public static void main(String[] args){
        ScenarioTests test = new ScenarioTests();
        test.setup();
    }
}
