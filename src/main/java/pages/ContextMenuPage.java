package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By contextBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickContextBox(){
        WebElement contextBoxField = driver.findElement(contextBox);
        Actions actions = new Actions(driver);
        actions.contextClick(contextBoxField).perform();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public String alert_getMessage(){
        return driver.switchTo().alert().getText();
    }
}
