package tests.day22_RaporluTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class tekrar extends TestBaseRapor {

    /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test01() {

        extentTest=extentReports.createTest("BlueRentalCars sitesi testi","Kullanıcı adı şifre doğru girilip giriş yapılıması kontrolu");
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalCarsUrl"));
        extentTest.info("Siteye girildi");

        BlueRentalcarsPage blueRentalcarsPage=new BlueRentalcarsPage();

        blueRentalcarsPage.loginButton.click();
        extentTest.info("Login butonuna tıklandı");

        blueRentalcarsPage.emailTextbox.sendKeys(ConfigReader.getProperty("emailBlueRentalCars"),
                                                Keys.TAB,ConfigReader.getProperty("passwordBlueRentalCars"),
                                                Keys.ENTER);
        extentTest.info("Kullanıcı adı şifre başarıyla girildi");

        Assert.assertTrue(blueRentalcarsPage.ddm.isDisplayed());
        extentTest.info("Giriş Başarılı");


    }
}
