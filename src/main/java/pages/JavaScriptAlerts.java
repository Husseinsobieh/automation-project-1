package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlerts {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[contains(text(),\"Click for JS Alert\")]");
    private By triggerConfirmButton = By.xpath(".//button[contains(text(),\"Click for JS Confirm\")]");
    private By triggerPromptButton = By.xpath(".//button[contains(text(),\"Click for JS Prompt\")]");
    private By results = By.id("result");


    public JavaScriptAlerts(WebDriver driver){
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }
    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }
    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public void alert_clickToCancel(){
        driver.switchTo().alert().dismiss();
    }
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }
    public String getResult(){
        return driver.findElement(results).getText();
    }
    public void alert_setPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
