package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String linkXpath_format = ".//a[contains(text(), '%s')]";
    private By linkExample1 = By.xpath(String.format(linkXpath_format, "Example 1"));
    private By linkExample2 = By.xpath(String.format(linkXpath_format, "Example 2"));

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(linkExample1).click();
        return new DynamicLoadingExample1Page(driver);
    }
    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(linkExample2).click();
        return new DynamicLoadingExample2Page(driver);
    }
}
