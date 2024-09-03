package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;


public class BaseTests {
    private WebDriver driver;
    protected HomePage homepage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().getPageLoadTimeout();
//        driver.manage().timeouts().getScriptTimeout();
        goHome();
        driver.manage().window().maximize();
        homepage = new HomePage(driver);

//        driver.manage().window().setSize(new Dimension(400, 900));
//        System.out.println(driver.getTitle());
//        WebElement inputsLink = driver.findElement(By.cssSelector("li a[href *= \"inputs\"]"));
//        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//        for(var link:links){
//            System.out.println(link.getText());
//        }
//        inputsLink.click();
//        try{
//            Thread.sleep(2000);
//        } catch (InterruptedException e){
//            System.out.println(e);
//        }
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

//    public static void main(String[] args){
//        BaseTests test = new BaseTests();
//        test.setup();
//        test.tearDown();
//    }
}
