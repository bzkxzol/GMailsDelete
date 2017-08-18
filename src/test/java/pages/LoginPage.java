package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailInputLocator = By.xpath("//*[@id=\"identifierId\"]");
    By nextButtonLoginLocator = By.cssSelector("#identifierNext > content > span");
    By passwordInputLocator = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
    By nextButtonPasswordLocator = By.cssSelector("#passwordNext > content > span");

    By moreButtonLocator = By.cssSelector(".CJ");
    By allMailsLocator = By.xpath("//a[@title='Вся почта']");

    By selectAllCheckboxLocator = By.xpath("//*[@class='T-I J-J5-Ji T-Pm T-I-ax7 L3 J-JN-M-I']/div[1]/span/div");
    By deleteButtonLocator = By.xpath("//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div/div");
    By submitDeleteLocator = By.xpath("/html/body/div[19]/div[3]/button[1]");

    By numberOfMailsLocator = By.xpath(".//*[@class=\"J-J5-Ji amH J-JN-I\"]/span/span[2]");


    public void typeEmail(String email) {
        WebElement login = driver.findElement(emailInputLocator);
        login.click();
        login.clear();
        login.sendKeys(email);
    }

    public void nextButtonLoginClick() throws InterruptedException {
        WebElement next = driver.findElement(nextButtonLoginLocator);
        next.click();
        Thread.sleep(500);
    }

    public void typePassword(String pass) throws InterruptedException {
        WebElement password = driver.findElement(passwordInputLocator);
        Thread.sleep(100);
        password.click();
        password.clear();
        password.sendKeys(pass);
    }

    public void nextButtonPasswordClick() {
        WebElement next = driver.findElement(nextButtonPasswordLocator);
        next.click();
    }

    public void moreButtonClick() throws InterruptedException {
        WebElement moreButton = driver.findElement(moreButtonLocator);
        moreButton.click();
        Thread.sleep(500);
    }

    public void allMailsClick() throws InterruptedException {
        WebElement allMails = driver.findElement(allMailsLocator);
        allMails.click();
        Thread.sleep(500);
    }

    public void selectAllCheckBoxClick() throws InterruptedException {
        WebElement selectAllCheckbox = driver.findElement(selectAllCheckboxLocator);
        Actions action = new Actions(driver);
        action.moveToElement(selectAllCheckbox).click().build().perform();
        Thread.sleep(100);
    }

    public void deleteButtonClick() {
        WebElement deleteButton = driver.findElement(deleteButtonLocator);
        deleteButton.click();
    }

    public void submitDeleteClick() {
        WebElement submitDeleteButton = driver.findElement(submitDeleteLocator);
        submitDeleteButton.click();
    }

    public void deleteAllMails() throws InterruptedException {
        WebElement numberOfMails = driver.findElement(numberOfMailsLocator);
        while (!numberOfMails.getText().equals("0")) {
            selectAllCheckBoxClick();
            deleteButtonClick();
            submitDeleteClick();
            Thread.sleep(1000);
        }
    }
}


