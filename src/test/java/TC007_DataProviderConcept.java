import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC007_DataProviderConcept {

    public static WebDriver driver;
    @BeforeMethod
    public void openApplication(){
        //open Application

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.get("https://www.surveymonkey.com/user/sign-in/?ut_source=megamenu&ut_ctatext=Sign+up&ut_source=homepage&ut_source3=megamenu");

    }

    @AfterMethod
    public void closeApplication () {

        driver.quit();
    }

    @Test(dataProvider = "applicationData")

    public void login (String un, String pwd) {

        driver.findElement(By.id("username")).sendKeys(un);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("Dashboard")).getText(), "Dashboard", "User login failed");
        System.out.println("User logged out successfully");
    }

    @DataProvider
    public Object[][] applicationData(){

        Object details[][] = new Object[2][2];
        details[0][0] = "seleniumtraining1";
        details[0][1] = "selenium1234";
        details[1][0] = "seleniumtraining2";
        details[1][1] = "selenium1234";

        return details;

    }
}
