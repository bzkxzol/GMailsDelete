package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class ChromeSettings {

    protected WebDriver driver;
    protected  String userEmail = "dimahpfsoft@gmail.com";
    protected  String userPassword = "qweRty123";

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver =  new ChromeDriver ();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.google.com");

    }

//    @AfterTest
//    public void tearDown(){
//        driver.close();
//    }
}
