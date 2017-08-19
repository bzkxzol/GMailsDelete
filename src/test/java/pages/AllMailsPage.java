package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AllMailsPage {
    private WebDriver driver;

    public AllMailsPage(WebDriver driver){
        this.driver = driver;
    }

    By moreButtonLocator = By.cssSelector(".CJ");
    By allMailsButtonLocator = By.xpath("//a[@href='https://mail.google.com/mail/u/0/#all']");
    By binButtonLocator = By.xpath("//a[@href='https://mail.google.com/mail/u/0/#trash']");

    By selectAllCheckboxLocator = By.xpath(".//*[@gh='tm']/div/div/div/div/div/div/div/span[@role='checkbox']");
    By deleteButtonLocator = By.xpath(".//*[@class='aeH']/div[2]/div[1]/div[1]/div/div/div[2]/div[3]");
    By submitDeleteLocator = By.xpath("/html/body/div[@role='alertdialog']/div[3]/button[1]");
    By deleteFromBinButtonLocator  = By.xpath(".//*[@gh='mtb']/div/div/div[2]/div/div");

    By numberOfMailsLocator = By.xpath(".//*[@gh='tm']/div/div[2]/div/span/div/span/span[2]");


    public void moreButtonClick() throws InterruptedException {
        WebElement moreButton = driver.findElement(moreButtonLocator);
        moreButton.click();
        Thread.sleep(500);
    }

    public void allMailsClick() throws InterruptedException {
        WebElement allMails = driver.findElement(allMailsButtonLocator);
        allMails.click();
        Thread.sleep(500);
    }

    public void binButtonClick() throws InterruptedException {
        WebElement binButton = driver.findElement(binButtonLocator);
        binButton.click();
        Thread.sleep(500);
    }

    public void deleteFromBinButtonClick(){
        WebElement deleteFromBinButton = driver.findElement(deleteFromBinButtonLocator);
        deleteFromBinButton.click();
    }

    public void selectAllCheckBoxClick() throws InterruptedException {
        WebElement selectAllCheckbox = driver.findElement(selectAllCheckboxLocator);
        Actions action = new Actions(driver);
        action.moveToElement(selectAllCheckbox).click().build().perform();
        Thread.sleep(200);
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
            selectAllCheckBoxClick();
            deleteButtonClick();
            submitDeleteClick();
            Thread.sleep(1500);
        }
    }

    public void deleteMailsFromBin() throws InterruptedException {

        while (isElementPresent(numberOfMailsLocator)){
            selectAllCheckBoxClick();
            deleteFromBinButtonClick();
            Thread.sleep(2000);
        }
    }

    public boolean isElementPresent(By selector){
        return driver.findElements(selector).size() > 0;
    }

}
