package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listener implements WebDriverListener{
    @Override
    public void beforeClick(WebElement element) {
        System.out.println("clicking on " + element.getText());
    }
}
