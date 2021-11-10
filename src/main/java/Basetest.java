import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Basetest {

    public  WebDriver driver;
    public Properties prop;

    //open Application
    @BeforeMethod
    public void openApplication() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Rudhira\\IdeaProjects\\TestNg\\config.properties");
        prop.load(fis);
        String browsername = prop.getProperty("browser");
       // String browName = "Chrome";
        if (browsername.equalsIgnoreCase("Chrome")) {

            /*WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();*/

            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "latest");
            caps.setCapability("name", "Demo Test");
            caps.setCapability("extendedDebugging", "true");
            //caps.setCapability("tunnelIdentifier", "oauth-pavanimulkalapally-83b21_tunnel_id");

            driver = new RemoteWebDriver(new URL("https://oauth-rudhira.katragadda-4673f:bbf3a26d-ac8a-4a69-a63f-577065766969@ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
            System.out.println("Thread ID Is : " + Thread.currentThread().getId());
            String sessionID = ((RemoteWebDriver) driver).getSessionId().toString();
            System.out.println("sessionID: "+sessionID);
            //driver.get("https://www.surveymonkey.com/");



        } else if (browsername.equalsIgnoreCase("Edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browsername.equalsIgnoreCase("Firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else{

            System.out.println("Please enter valid browser name");
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void closeApplication() {

        driver.quit();
    }
}
