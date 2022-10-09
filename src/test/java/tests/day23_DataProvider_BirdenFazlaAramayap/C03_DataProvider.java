package tests.day23_DataProvider_BirdenFazlaAramayap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalcarsPage;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"mustafa@gmail.com","12345"},
                {"sak@gmail.com,456545"},
                {"customer@bluerentalcars.com","123456"}};
    }

    @Test(dataProvider = "kullanicilar")
    public void test01(String userEmail,String password) {
        //https://www.bluerentalcars.com/ adresine git
        SaucedemoPage saucedemoPage=new SaucedemoPage();

        Driver.getDriver().get(ConfigReader.getProperty("sauceUrl"));

        //login butonuna bas
        saucedemoPage.loginButton.click();

        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
  /*      blueRentalcarsPage.emailTextbox.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(blueRentalcarsPage.emailTextbox).sendKeys(userEmail,Keys.TAB,password,Keys.ENTER).perform();
*/
        //login butonuna tiklayin
        saucedemoPage.userNameTextBox.sendKeys(userEmail);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(password)
                .sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        // Assert.assertTrue(blueRentalcarsPage.ikinciLogin.isDisplayed());
    }

}
