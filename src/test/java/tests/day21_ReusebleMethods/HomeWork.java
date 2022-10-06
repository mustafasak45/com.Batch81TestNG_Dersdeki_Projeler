package tests.day21_ReusebleMethods;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiburadaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomeWork {
    //Hepsiburada sayfasına gidiniz
    //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
    //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
    //Sayfayı kapatalım

    @Test
    public void test01() throws InterruptedException {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım


        HepsiburadaPage hepsiburadaPage=new HepsiburadaPage();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hepsiburadaPage.elektronik).perform();
        ReusableMethods.waitFor(1);
        actions.moveToElement(hepsiburadaPage.bilgisayarTablet).perform();

        String homePage=Driver.getDriver().getWindowHandle();
        for (int i = 0; i <hepsiburadaPage.anaveAltBasliklar.size() ; i++)
         {
            hepsiburadaPage.anaveAltBasliklar.get(i).click();
            ReusableMethods.waitFor(4);

             actions.moveToElement(hepsiburadaPage.elektronik).perform();
             ReusableMethods.waitFor(1);
             actions.moveToElement(hepsiburadaPage.bilgisayarTablet).perform();

        }
        System.out.println(hepsiburadaPage.anaveAltBasliklar.size());


    }
}
