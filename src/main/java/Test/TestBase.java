package Test;

import Pages.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;
    protected PageFactory pageFactory;

    public TestBase()  {
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Config\\config.properties");
            prop = new Properties();
            prop.load(ip);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @BeforeClass
    public void initialization() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        pageFactory = new PageFactory(driver);
        implicitWait();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    public static void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
