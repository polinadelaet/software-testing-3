package answers;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reader.ConfigProvider;

public class NotificationPage extends BaseSeleniumPage {

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div[2]/h2")
    private WebElement notificationPageValue;

    public NotificationPage () {
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public String getNotificationPageValue() {
        return notificationPageValue.getText();
    }
}
