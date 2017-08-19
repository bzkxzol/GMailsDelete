package tests;

import org.testng.annotations.Test;
import pages.AllMailsPage;
import pages.LoginPage;
import settings.ChromeSettings;

public class Tests  extends ChromeSettings{

    @Test
    public void deleteMails() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        AllMailsPage allMailsPage = new AllMailsPage(driver);

        loginPage.typeEmail(userEmail);
        loginPage.nextButtonLoginClick();
        loginPage.typePassword(userPassword);
        loginPage.nextButtonPasswordClick();

        //Удаление писем из инбокса
        allMailsPage.moreButtonClick();
        allMailsPage.allMailsClick();
        allMailsPage.deleteAllMails();
        //Удаление писем из корзины
        allMailsPage.binButtonClick();
        allMailsPage.deleteMailsFromBin();

        System.out.println("Test passed!\nAll mails has been deleted");

    }
}
