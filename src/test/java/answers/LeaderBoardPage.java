package answers;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reader.ConfigProvider;

import java.util.List;

public class LeaderBoardPage extends BaseSeleniumPage {

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[4]/div")
    private List<WebElement> listOfLeaders;

    @FindBy(xpath = "//a[text()='All Time']")
    private WebElement buttonListOfLeadersAllTime;

    @FindBy(xpath = "//a[text()='My Stats']")
    private WebElement buttonMyStats;

    public LeaderBoardPage () {
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public int getAmountOfLeaders() {
        return listOfLeaders.size();
    }

    public void showLeadersAllTime() {
        buttonListOfLeadersAllTime.click();
    }

    public void showMyStats() {
        buttonMyStats.click();
    }
}
