package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     *scrolls to the paragraph with the index specified
     * @param index starts at 1
     */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        while (getNumberOfParagraphs() < index){
            ((JavascriptExecutor)driver).executeScript(script);
        }
    }
    public int getNumberOfParagraphs(){
        return driver.findElements(textBlocks).size();
    }
}
