package answers;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reader.ConfigProvider;

import java.time.Duration;

public class GuidePage extends BaseSeleniumPage {

    @FindBy(xpath = "//textarea[1]")
    private WebElement guideTitleForm;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/div[1]/button")
    private WebElement guideSubmitForm;

    public GuidePage () {
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public String createGuide(String title) {
        guideTitleForm.sendKeys(title);
        guideSubmitForm.click();
        WebElement myElement = (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[5]/div/span[2]")));
        return myElement.getAttribute("class");

    }
}
