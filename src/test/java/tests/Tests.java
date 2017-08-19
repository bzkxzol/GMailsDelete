package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import settings.ChromeSettings;

public class Tests  extends ChromeSettings{

    @Test
    public void deleteMails() throws InterruptedException{
        LoginPage loginpage = new LoginPage(driver);

        loginpage.typeEmail(userEmail);
        loginpage.nextButtonLoginClick();

        loginpage.typePassword(userPassword);
        loginpage.nextButtonPasswordClick();
        //Удаление писем из инбокса
        loginpage.moreButtonClick();
        loginpage.allMailsClick();
        loginpage.deleteAllMails();
        //Удаление писем из корзины
        loginpage.binButtonClick();
        loginpage.deleteMailsFromBin();

        System.out.println("Test passed!\nAll mails has been deleted");

    }
}
