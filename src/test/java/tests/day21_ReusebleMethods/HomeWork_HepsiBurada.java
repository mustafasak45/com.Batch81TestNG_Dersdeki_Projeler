package tests.day21_ReusebleMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiburadaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class HomeWork_HepsiBurada {
    //Hepsiburada sayfasına gidiniz
    //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
    //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
    //Sayfayı kapatalım
    HepsiburadaPage hepsiburadaPage=new HepsiburadaPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException, IOException {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım

        menu();//fordan önce bu methodu calıştırmayınca tıklanacak elemenleri atadıgım list elementleri almıyor
        System.out.println(hepsiburadaPage.anaveAltBasliklar.size());
      //  List<WebElement> elementlerList = (hepsiburadaPage.anaveAltBasliklar);
        hepsiburadaPage.anaveAltBasliklar.get(0).click();
        Driver.getDriver().navigate().back();

       for (int i = 1; i <hepsiburadaPage.anaveAltBasliklar.size() ; i++)
         {

             menu();
            hepsiburadaPage.anaveAltBasliklar.get(i).click();

            ReusableMethods.getScreenshot("hepsiburada - ");
            Driver.getDriver().navigate().back();
        }
    }
    private void menu() {
        actions.moveToElement(hepsiburadaPage.elektronik).click().perform();
        ReusableMethods.hover(hepsiburadaPage.elektronik);
        actions.moveToElement(hepsiburadaPage.bilgisayarTablet).perform();
        ReusableMethods.waitForVisibility(hepsiburadaPage.bilgisayarTablet,3);
        ReusableMethods.hover(hepsiburadaPage.bilgisayarTablet);

      /*  hepsiburadaPage.elektronik.click();
        ReusableMethods.hover(hepsiburadaPage.elektronik);
        ReusableMethods.waitForVisibility(hepsiburadaPage.bilgisayarTablet,3);
        ReusableMethods.hover(hepsiburadaPage.bilgisayarTablet);
        ReusableMethods.waitForVisibility((WebElement) hepsiburadaPage.anaveAltBasliklar,3); // 66 Webelementi
        */
    }
}
