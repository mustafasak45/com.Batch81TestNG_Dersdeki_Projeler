package tests.day20_SmokeTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_E2ETest {
    @Test
    public void E2ETest() throws InterruptedException {

//        Tests packagenin altına class olusturun: CreateHotel
//        Bir metod olusturun: createHotel
//        https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        HmcPage hmcPage=new HmcPage();
        hmcPage.login.click();

//        Username textbox ve password metin kutularını locate edin ve asagidaki verileri
//        Username : manager
//        Password  : Manager1!
//                Login butonuna tıklayın.
        Actions actions=new Actions(Driver.getDriver());
        hmcPage.userNameTextBox.sendKeys(ConfigReader.getProperty("userName"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"), Keys.ENTER).perform();



//        Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hmcPage.hotelManagement.click();
        Thread.sleep(1000);
        hmcPage.roomReservation.click();
        Thread.sleep(1000);
        hmcPage.addRoom.click();

//        Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Faker faker = new Faker();
        hmcPage.idUser.sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/01/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys("skajdlaksjdaasd")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //“RoomReservation was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(1000);
        Assert.assertTrue(hmcPage.roomReservationText.isDisplayed());

        //OK butonuna tıklayın.
        hmcPage.okButton.click();

        Driver.closeDriver();


    }
}
