
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class TC004_OrangeHRMApplication extends Basetest{


        //Test1 --> Verify the title of the application
        @Test(priority = 1)
        public void verifyApplication () {

            String actTitle = driver.getTitle();
            String expTitle = "OrangeHRM";
            Assert.assertEquals(actTitle, expTitle, "Title is not " + actTitle);
            System.out.println("Title is matching");
        }

        //open Application
        //Test1 --> Verify if forgot password? link is present
        @Test(priority = 2)

        public void verifyForgotPassword () {

            boolean linkstatus = driver.findElement(By.linkText("Forgot your password?")).isDisplayed();
            Assert.assertTrue(linkstatus, "Forgot your password? link is missing");

            System.out.println("Forgot your password? link is displayed");
        }
        //close Application

        //open Application
        //Test1 --> Login

        @Test(priority = 3)

        public void login () {

            driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("username"));
            driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("password"));
            driver.findElement(By.id("btnLogin")).click();
            Assert.assertEquals(driver.findElement(By.id("menu_dashboard_index")).getText(), "Dashboard", "User login failed");
            System.out.println("User logged out successfully");
        }
        //close Application
    }



