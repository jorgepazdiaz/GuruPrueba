package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;
    public static String navegador= "Chrome";


    @Before
    public static void setUp(){

        switch (navegador) {
            case "Chrome": {

                System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            }
            case "Firefox": {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            }
            case "Edge": {
                System.setProperty("webdriver.edge.driver", "src/test/resources/driver/msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            }

        }

    }


    @After
    public static void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","Failed");
        }
        driver.manage().deleteAllCookies();
        driver.close();
    }

    public static WebDriver getDriver(){
        return driver;
    }


}
