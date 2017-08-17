package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailInput = By.xpath("//*[@id=\"identifierId\"]");
    By nextButtonLogin = By.cssSelector("#identifierNext > content > span");
    By passwordInput = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
    By nextButtonPassword = By.cssSelector("#passwordNext > content > span");

    public void typeEmail(String email){
        WebElement login  = driver.findElement(emailInput);
        login.click();
        login.clear();
        login.sendKeys(email);
    }

    public void nextButtonLoginClick() throws InterruptedException {
        WebElement next = driver.findElement(nextButtonLogin);
        next.click();
        Thread.sleep(500);
    }

    public void typePassword(String pass){
        WebElement password  = driver.findElement(passwordInput);
        password.click();
        password.clear();
        password.sendKeys(pass);
    }
    public void nextButtonPasswordClick(){
        WebElement next = driver.findElement(nextButtonPassword);
        next.click();
    }

}
