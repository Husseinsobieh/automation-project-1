package forgotpassword;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

public class ForgotPasswordTests extends BaseTests {
    @Test
    public void testForgotPassword(){
        ForgotPasswordPage forgotPasswordPage = homepage.clickForgotPassword();
        forgotPasswordPage.setEmailInput("tau@example.com");
        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();
        Assert.assertEquals(emailSentPage.getMessage(), "Your e-mail's been sent!", "Message is incorrect");
    }
}
