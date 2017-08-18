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

        loginpage.moreButtonClick();
        loginpage.allMailsClick();
        loginpage.deleteAllMails();

    }
}
