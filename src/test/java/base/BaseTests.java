package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.Listener;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homepage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        Listener listener = new Listener();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(listener);
        driver = decorator.decorate(new ChromeDriver(getChromeOptions()));
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().getPageLoadTimeout();
//        driver.manage().timeouts().getScriptTimeout();
        goHome();
        setCookie();
//        driver.manage().window().maximize();
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
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch (IOException err){
                System.out.println(err);
            }
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.addArguments("--headless");
        return options;
    }
    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
//    public static void main(String[] args){
//        BaseTests test = new BaseTests();
//        test.setup();
//        test.tearDown();
//    }
}
