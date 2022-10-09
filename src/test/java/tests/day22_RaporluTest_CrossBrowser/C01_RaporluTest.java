package tests.day22_RaporluTest_CrossBrowser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {

/*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    BlueRentalcarsPage blueRentalcarsPage=new BlueRentalcarsPage();
    @Test
    public void test01() {
   //     -https://www.bluerentalcars.com/ adresine git

        extentTest=extentReports.createTest("PozitifTest","Gecerli Kullaici adi ve password ile giriş yapıldı");

        Driver.getDriver().get(ConfigReader.getProperty("bluerentalCarsUrl"));
        extentTest.info("Blue RentaCar sitesine gidildi");

        //    -login butonuna bas
        blueRentalcarsPage.loginButton.click();
        extentTest.info("Login butonuna basıldı");

// -test data user email: customer@bluerentalcars.com ,
//  -test data password : 12345 dataları girip login e basın
//        -login butonuna tiklayin
        Actions actions=new Actions(Driver.getDriver());
        actions.click(blueRentalcarsPage.emailTextbox).sendKeys(ConfigReader.getProperty("emailBlueRentalCars"),Keys.TAB).
                sendKeys(ConfigReader.getProperty("passwordBlueRentalCars"),Keys.ENTER).perform();
        extentTest.info("Eposta şifre girildi");

// -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(blueRentalcarsPage.ddm.isDisplayed());
        extentTest.pass("Sayfaya başarılı şekilde girildi");

    }
}
