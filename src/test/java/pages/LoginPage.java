package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailInputLocator = By.xpath("//*[@id=\"identifierId\"]");
    By nextButtonLoginLocator = By.cssSelector("#identifierNext > content > span");
    By passwordInputLocator = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
    By nextButtonPasswordLocator = By.cssSelector("#passwordNext > content > span");

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
}


