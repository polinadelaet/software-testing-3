package answers;

import core.BaseSeleniumPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reader.ConfigProvider;

import java.util.List;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//input")
    private WebElement inputQuestion;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[2]/main/section[1]/div[2]/button")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[4]/div/input")
    private WebElement searchInputAbove;

    @FindBy(xpath = "//a[contains(@href,'/search')]")
    private List<WebElement> listOfSectionInAnswer;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[2]/main/div[2]/a")
    private List<WebElement> subjects;

    @FindBy(xpath = "//a[contains(@href, 'notifications')]")
    private WebElement notifications;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement logInLogin;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement logInPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement logInSubmit;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div[2]/div[2]/div/button[4]")
    private WebElement toLogInWithEmail;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[1]/div/div/div/span[1]/button")
    private WebElement createQuestionButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[1]/div/div/div/span[2]/button")
    private WebElement createGuideButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/textarea")
    private WebElement createQuestionTextArea;

    @FindBy(xpath = "//button[@aria-label = 'Submit Input']")
    private WebElement createQuestionSubmit;

    @FindBy(xpath = "//span[text()='You are not allowed to do that.']")
    private WebElement resultOfCreationQuestion;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[2]/span")
    private WebElement leaderBoard;

    @FindBy(xpath = "//button[@id='profile-menu']")
    private WebElement profileMenuButton;

    @FindBy(xpath = "//span[text()='Profile']")
    private WebElement myProfileButton;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement logInButton;

    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement logInButtonUnderQuestion;

    @FindBy(xpath = "//a[text()='Sign up']")
    private WebElement signUpButtonUnderQuestion;

    @FindBy(xpath = "//input[@id='email-input']")
    private WebElement signUpEmailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement signUpPasswordInput;

    @FindBy(xpath = "//div[@value='tos']")
    private WebElement privacyCheckBox;

    @FindBy(xpath = "//div[@value='contact']")
    private WebElement contactCheckBox;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private WebElement captcha;

    @FindBy(xpath = "//a[@href = 'https://www.answers.com/']")
    private WebElement mainPageButton;

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[2]/main/section[3]/div/div/div[1]/a")
    private List<WebElement> categories;

    public MainPage () {
        driver.get(ConfigProvider.URl);
        PageFactory.initElements(driver, this);
    }

    public void clickToNotifications() {
        notifications.click();
    }

    public String askQuestion(String question) {
        inputQuestion.sendKeys(question);
        submitButton.click();
        return searchInputAbove.getAttribute("value");
    }

    public int getAmountOfSectionsInAnswer() {
        return listOfSectionInAnswer.size();
    }

    public String browseSubject(int i) {
        subjects.get(i).click();
        return title.getText();
    }

    public void logInWithEmail(String login, String password) {
        toLogInWithEmail.click();
        logInLogin.sendKeys(login);
        logInPassword.sendKeys(password);
        logInSubmit.click();
    }

    public void createQuestionBeforeLogIn(String question) {
        createButton.click();
        createQuestionButton.click();
        createQuestionTextArea.sendKeys(question);
        createQuestionSubmit.click();
    }

    public void createQuestionAfterLogIn() {
        createQuestionSubmit.click();
    }

    public void createGuide() {
        createButton.click();
        createGuideButton.click();
    }

    public void openLeaderBoard() {
        try {
            leaderBoard.click();
        } catch (TimeoutException ignore) {
        }
    }

    public void openProfile() {
        profileMenuButton.click();
        myProfileButton.click();
    }

    public void logIn() {
        logInButton.click();
    }

    public void logInUnderQuestion() {
        logInButtonUnderQuestion.click();
    }

    public String clickMainPage() {
        mainPageButton.click();
        return title.getText();
    }

    public String openCategory(int i) {
        categories.get(i).click();
        return title.getText();
    }
}
