package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class TestBase_BeforeClass_AfterClass {// obje oluşturulmasını engellemek için abstract yaptık

    protected static WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public static void setup(@Optional String browser){
        driver=CrossDriver.getDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown(){
    CrossDriver.closeDriver();
    }

}
