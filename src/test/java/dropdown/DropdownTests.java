package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption(){
        DropdownPage dropdownPage = homepage.clickDropdown();
        dropdownPage.selectOptionFromDropdown("Option 1");
        var selectedList = dropdownPage.getSelectedOptions();
        for(var item: selectedList){
            System.out.println(item);
        }
        Assert.assertEquals(selectedList.size(), 1, "Incorrect Number of Selections");
        Assert.assertTrue(selectedList.contains("Option 1"), "Option not Selected");
    }
}
