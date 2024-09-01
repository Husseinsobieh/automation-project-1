package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage {
    private WebDriver driver;
    private By input = By.id("target");
    private By result = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        driver.findElement(input).sendKeys(text);
    }
    public String enteredText(){
        return driver.findElement(result).getText();
    }
    public void enterPi(){
        driver.findElement(input).sendKeys("\u03C0=3.14");
    }
}
