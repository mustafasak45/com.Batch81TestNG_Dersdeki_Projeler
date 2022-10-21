package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.Driver;

@Listeners(utilities.Listeners.class)//Listeners classı ile burada bağlatı kurduruyoruz
                                    //listeners classındaki methodları tektek kontrol edip testlerin Fail/Pass/Ignore
                                    //durumuna göre çalıştırıyor
public class ListenersTest2 {
    //bu classı test Fail olduğunda ekran fotosu aldıgını kontrol etmek için yaptım
    @Test
    public void test01() {
        //1-amazon anasayfaya gidin
        Driver.getDriver().get("https://amazon.com");


        //2-title in Amazon içerdigini test edin
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon1"));
          }
}
