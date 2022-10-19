package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {

    protected  WebDriver driver;
    @Parameters("browser") //bu notasyon configuration.properties dosyasındaki browser yazan valuenin değerini alır
    @BeforeClass        //Parent class bu class oldugu için child classlar ilk buradaki before yi caliştirir
    public void setUp(@Optional String browser){//@Parameters notasyonundaki değeri buraya almak icin @Optional kullanılır
        driver=CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown(){
        CrossDriver.closeDriver();
    }
}
