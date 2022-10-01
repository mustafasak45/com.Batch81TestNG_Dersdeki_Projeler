package tests.day19_SignletonPattern_NegatifPozitifTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegatifTest {
    @Test
    public void negatifTest() {

//        1 ) Bir Class olustur : NegativeTest
//        2) Bir test method olustur NegativeLoginTest()

//        https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

//        login butonuna bas
        HmcPage hmcPage=new HmcPage();
        hmcPage.login.click();

//        test data username:manager1 ,  test data password : manager1!
        hmcPage.userNameTextBox.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPassword")).sendKeys(Keys.ENTER).perform();

//         Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
    }
}
