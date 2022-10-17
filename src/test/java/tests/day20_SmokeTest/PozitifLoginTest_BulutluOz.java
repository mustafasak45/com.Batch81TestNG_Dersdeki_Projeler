package tests.day20_SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BlueRentACarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest_BulutluOz {
    @Test
    public void positiveLoginTest() {
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalCarsUrl"));

        //login butonuna bas
        BlueRentACarsPage blueRentalcarsPage=new BlueRentACarsPage();
        blueRentalcarsPage.loginButton.click();

        //     emailBlueRentalCars=customer@bluerentalcars.com
        //     passwordBlueRentalCars=12345

        blueRentalcarsPage.emailTextbox.sendKeys(ConfigReader.getProperty("emailBlueRentalCars"),
                Keys.TAB,ConfigReader.getProperty("passwordBlueRentalCars"),
                Keys.ENTER);


        SoftAssert softAssert=new SoftAssert(); //SoftAsserti hatırlama için kullandım Assert ile de olur
        softAssert.assertTrue(blueRentalcarsPage.ddm.isDisplayed());
       // softAssert.assertFalse(blueRentalcarsPage.ddm.isDisplayed(),"Hatalı sonuc");

        softAssert.assertAll();

    }
}
