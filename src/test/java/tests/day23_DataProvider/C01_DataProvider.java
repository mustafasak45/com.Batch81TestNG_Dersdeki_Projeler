package tests.day23_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};//aranması istenilen kelimeler buraya girildi
    }

    @Test(dataProvider = "aranacakKelimeler")//ilk burayı yazdıktan sonra açılan pencereden yazıya tıklayınca yukarıdaki @DataProvider oluşur
    public void test02(String kelimeler) {
        AmazonPage amazonPage = new AmazonPage();

//amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));

//java, selenium, samsung ve iphone icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(kelimeler,Keys.ENTER);

//sonuclarin aradigimiz kelime icerdigini test edelim
        String actualKelime = amazonPage.aramaSonucWE.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));

//sayfayi kapatalim
    //    Driver.closeDriver();   //eğer burada kapatırsak her aramada browseri açıp kapatır
    }

    @Test(dependsOnMethods = "test02")  //bu notasyonu yapmamızın sebebide test02 çalışsın bütün aramalar bittikten
    public void test03() {              //sonra browseri kapatıyoruz. bu yüzden 33. satırı yoruma aldık
        Driver.closeDriver();
    }
}
