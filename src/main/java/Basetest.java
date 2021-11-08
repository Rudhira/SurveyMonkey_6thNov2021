import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;
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

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();


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
