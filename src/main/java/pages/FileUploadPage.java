package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By fileInputButton = By.id("file-upload");
    private By fileSubmitButton = By.id("file-submit");
    private By uploadedFileName = By.id("uploaded-files");
    private By uploadedFileMessage = By.cssSelector(".example h3");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickFileInputButton(){
        driver.findElement(fileInputButton).click();
    }
    public void clickFileSubmitButton(){
        driver.findElement(fileSubmitButton).click();
    }
    /**
     * provides path of file to the form and then clicks upload button
     * @param absolutePath The complete path of the file to upload
     */
    public void uploadFile(String absolutePath){
        driver.findElement(fileInputButton).sendKeys(absolutePath);
        clickFileSubmitButton();
    }
    public String getUploadedFileName(){
        return driver.findElement(uploadedFileName).getText();
    }
    public String getUploadedFileMessage(){
        return driver.findElement(uploadedFileMessage).getText();
    }
}
