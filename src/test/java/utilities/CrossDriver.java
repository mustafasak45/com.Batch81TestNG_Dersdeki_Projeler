package utilities;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.edge.EdgeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import java.time.Duration;

public class CrossDriver {
    private CrossDriver() {
 /*
        SingletonPattern : tekli kullanım demektir. Bir class'ın farklı class'lardan
        obje oluşturarak kullanımını engellemektir.
        Bunu da buradaki gibi private constructor yapmaktır

         */
    }
    static WebDriver driver;
    public static WebDriver getDriver(String browser){
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        //Testlerimizi xml file'den farklı browserler ile çalıştırabilmek için getDriver()
        // methoduna parametre atmamız gerekir.
        if (driver==null){                                  //driver'i bir kere calistirir(browser 1 kere açılır)
            switch (browser){
                //CrossBrowser için bizim gönderdigimiz browser üzerinden çalışması için
                //buraya parametre olarak girdigimiz değeri yazdık
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup(); //hiç birşey çalışmazsa chrome calışsın
                    driver=new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
    public static void closeDriver(){
        if (driver!=null) {
            driver.close();
            driver=null; //kapandıktan sonra driveri tekrar açılmasında problem olmaması için null yaptık
        }
    }
    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}

