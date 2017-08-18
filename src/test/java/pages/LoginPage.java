package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


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

    By selectAllCheckboxLocator = By.xpath(".//*[@gh='tm']/div/div/div/div/div/div/div/span[@role='checkbox']");
    By deleteButtonLocator = By.xpath(".//*[@class='aeH']/div[2]/div[1]/div[1]/div/div/div[2]/div[3]");
    By submitDeleteLocator = By.xpath("/html/body/div[@role=\"alertdialog\"]/div[3]/button[1]");

    By numberOfMailsLocator = By.xpath(".//*[@gh='tm']/div/div[2]/div/span/div/span/span[2]");


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

        while (isElementPresent(numberOfMailsLocator)) {
            Thread.sleep(1000);
            selectAllCheckBoxClick();
            deleteButtonClick();
            submitDeleteClick();
        }
    }

    public boolean isElementPresent(By selector){
        return driver.findElements(selector).size() > 0;
    }
}


