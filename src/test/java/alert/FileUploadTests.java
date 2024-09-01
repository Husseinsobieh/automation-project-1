package alert;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        String absolutePath = "C:\\Users\\Arthur\\Desktop\\7s\\Java\\Learning\\SeleniumWebDriver\\resources\\chromedriver.exe";
        FileUploadPage fileUploadPage = homepage.clickFileUpload();
        fileUploadPage.uploadFile(absolutePath);
        Assert.assertTrue(fileUploadPage.getUploadedFileName().contains("chromedriver"), "file name incorrect");
        Assert.assertEquals(fileUploadPage.getUploadedFileMessage(), "File Uploaded!", "upload message incorrect");
    }
}
