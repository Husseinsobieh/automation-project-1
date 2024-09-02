package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String frameID = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By indentationButton = By.cssSelector("button[aria-label=\"Increase indent\"]");

    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(frameID);
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void increaseIndentation(){
        driver.findElement(indentationButton).click();
    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
}
