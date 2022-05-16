package core;

import answers.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reader.ConfigProvider;

import java.time.Duration;

abstract public class BaseSeleniumTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected GuidePage guidePage;
    protected LeaderBoardPage leaderBoardPage;
    protected MyProfilePage myProfilePage;
    protected NotificationPage notificationPage;

    @AfterEach
    void closeAll() {
        driver.quit();
    }

    @Test
    void getNotificationTest() {
        mainPage.clickToNotifications();
        mainPage.logInWithEmail(ConfigProvider.USER1_LOGIN, ConfigProvider.USER1_PASSWORD);
        (new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.presenceOfElementLocated(By.id("profile-menu")));
        notificationPage = new NotificationPage();
        mainPage.clickToNotifications();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/notifications");
    }

    @Test
    void createQuestion() {
        mainPage.createQuestionBeforeLogIn("What is the most useful site about Kubrick?");
        mainPage.logInWithEmail(ConfigProvider.USER1_LOGIN, ConfigProvider.USER1_PASSWORD);
        mainPage.createQuestionAfterLogIn();
        WebElement myElement = (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/span[2]")));
        Assertions.assertEquals(myElement.getAttribute("class"), "overflow-hidden");
    }

    @Test
    void createGuide() throws InterruptedException {
        mainPage.createGuide();
        mainPage.logInWithEmail(ConfigProvider.USER1_LOGIN, ConfigProvider.USER1_PASSWORD);
        (new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.presenceOfElementLocated(By.id("profile-menu")));
        Thread.sleep(3000);
        mainPage.createGuide();
        String classOfResult = guidePage.createGuide("Kek");
        Assertions.assertEquals(classOfResult, "overflow-hidden");
    }

    @Test
    void showLeaderBoardThisWeek() {
        mainPage.openLeaderBoard();
        Assertions.assertTrue(leaderBoardPage.getAmountOfLeaders() > 0);
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/leaderboard/weekly-stats");
    }

    @Test
    void showLeaderBoardAllTime() {
        mainPage.openLeaderBoard();
        leaderBoardPage.showLeadersAllTime();
        Assertions.assertTrue(leaderBoardPage.getAmountOfLeaders() > 0);
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/leaderboard/all-time");
    }

    @Test
    void showLeaderBoardMyStats()  {
        mainPage.openLeaderBoard();
        leaderBoardPage.showMyStats();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/leaderboard/my-stats");
    }

    @Test
    void logInAndTestOwnPage() {
        mainPage.logIn();
        mainPage.logInWithEmail(ConfigProvider.USER1_LOGIN, ConfigProvider.USER1_PASSWORD);
        (new WebDriverWait(driver, Duration.ofSeconds(50))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, 'https://www.answers.com/u/')]")));
        mainPage.openProfile();
        Assertions.assertEquals(myProfilePage.getAmountOfSections(), 3);
    }

    @Test
    void askQuestion() {
        String question = "who are u?";
        String searchInputAboveValue = mainPage.askQuestion(question);
        Assertions.assertEquals(searchInputAboveValue, question);
        Assertions.assertEquals(mainPage.getAmountOfSectionsInAnswer(), 3);
    }

    @Test
    void logInUnderQuestion() {
        mainPage.logInUnderQuestion();
        mainPage.logInWithEmail(ConfigProvider.USER1_LOGIN, ConfigProvider.USER1_PASSWORD);
        (new WebDriverWait(driver, Duration.ofSeconds(50))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, 'https://www.answers.com/u/')]")));
        mainPage.openProfile();
        Assertions.assertEquals(myProfilePage.getAmountOfSections(), 3);
    }

    @Test
    void clickMainPageTest() {
        String title = mainPage.clickMainPage();
        Assertions.assertEquals(title, "What is your question?");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/");
    }

    @Test
    void openSubjectMathTest() {
        String title = mainPage.browseSubject(0);
        Assertions.assertEquals(title, "➗ Math");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/math");
    }

    @Test
    void openSubjectSocialStudiesTest() {
        String title = mainPage.browseSubject(4);
        Assertions.assertEquals(title, "\uD83E\uDD1D Social Studies");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/social-studies");
    }

    @Test
    void openCategoryAmericanGovernmentTest() {
        String title = mainPage.openCategory(0);
        Assertions.assertEquals(title, "\uD83C\uDFDB️ American Government");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/american-government");
    }

    @Test
    void openCategoryPhysicsTest() {
        String title = mainPage.openCategory(5);
        Assertions.assertEquals(title, "⚛️ Physics");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.answers.com/physics");
    }
}
