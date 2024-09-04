package alert;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
        JavaScriptAlertsPage javaScriptAlerts = homepage.clickJavaScriptAlerts();
        javaScriptAlerts.triggerAlert();
        javaScriptAlerts.alert_clickToAccept();
        Assert.assertEquals(javaScriptAlerts.getResult(), "You successfully clicked an alert", "result incorrect");
    }
    @Test
    public void testGetTextFromAlert(){
        JavaScriptAlertsPage javaScriptAlerts = homepage.clickJavaScriptAlerts();
        javaScriptAlerts.triggerConfirm();
        String text = javaScriptAlerts.alert_getText();
        javaScriptAlerts.alert_clickToCancel();
        Assert.assertEquals(javaScriptAlerts.getResult(),"You clicked: Cancel","result incorrect");
        Assert.assertEquals(text, "I am a JS Confirm", "result incorrect");
    }
    @Test
    public void testGetPromptFromAlert(){
        String text = "TAU rocks!";
        JavaScriptAlertsPage javaScriptAlerts = homepage.clickJavaScriptAlerts();
        javaScriptAlerts.triggerPrompt();
        javaScriptAlerts.alert_setPrompt(text);
        javaScriptAlerts.alert_clickToAccept();
        Assert.assertEquals(javaScriptAlerts.getResult(), "You entered: " + text, "result incorrect");
    }
}
