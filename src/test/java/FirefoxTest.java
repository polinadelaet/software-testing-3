import answers.*;
import core.BaseSeleniumPage;
import core.BaseSeleniumTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;

public class FirefoxTest extends BaseSeleniumTest {

    @BeforeEach
    void initPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        BaseSeleniumPage.setDriver(driver);
        mainPage =  new MainPage();
        guidePage = new GuidePage();
        leaderBoardPage = new LeaderBoardPage();
        myProfilePage = new MyProfilePage();
    }

}
