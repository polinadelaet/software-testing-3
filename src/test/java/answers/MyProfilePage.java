package answers;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reader.ConfigProvider;

import java.util.List;

public class MyProfilePage extends BaseSeleniumPage {

    @FindBy(xpath = "//a[contains(@href,'/questions')]")
    private List<WebElement> listOfSections;

    public MyProfilePage () {
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public int getAmountOfSections() {
        return listOfSections.size();
    }
}
