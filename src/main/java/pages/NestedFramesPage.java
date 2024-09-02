package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private By leftFrame = By.tagName("body");
    private By bottomFrame = By.tagName("body");

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    public void switchToLeftFrame(){
        driver.switchTo().frame("frame-top").switchTo().frame("frame-left");
    }
    public void switchToBottomFrame(){
        driver.switchTo().frame("frame-bottom");
    }
    public void switchToMainFrame(){
        driver.switchTo().parentFrame().switchTo().parentFrame();
    }
    public String getTextFromLeftFrame(){
        switchToLeftFrame();
        String text = driver.findElement(leftFrame).getText();
        switchToMainFrame();
        return text;
    }
    public String getTextFromBottomFrame(){
        switchToBottomFrame();
        String text = driver.findElement(bottomFrame).getText();
        switchToMainFrame();
        return text;
    }
}
