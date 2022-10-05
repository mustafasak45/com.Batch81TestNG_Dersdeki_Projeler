package tests.Practice.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
    // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
// Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
//Tüm yapılacakların üzerini çiz.
//Tüm yapılacakları sil.
//Tüm yapılacakların silindiğini doğrulayın.

 /*   Keşif Testi (Exploratory Testing) , test senaryolarının önceden oluşturulmadığı,
    testçilerin sistemi test anında kontrol ettiği bir tür yazılım testidir.
    Herhangi bir test senaryosuna bağlı kalmaksızın yazılımları serbestçe keşfederek buldukları
        bug’ları raporlamasına dayanır. Test uzmanlarının minimum planlama ve maksimum test uygulamasına
    katıldığı uygulamalı bir yaklaşımdır. Testin yürütülmesinden önce neyin test edileceğine dair fikirleri
    not edebilirler.*/
    @Test
    public void test01() throws InterruptedException {
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webdriveruniversityUrl"));

        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)

        WebUniversityPage webUniversityPage=new WebUniversityPage();
        List<String> workList=new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka", "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));
        Actions actions=new Actions(Driver.getDriver());
/*

        for (String w:workList) {
            actions.click(webUniversityPage.addNewTodo).sendKeys(w,Keys.ENTER).perform();
        }
*/
        workList.forEach(t->actions.click(webUniversityPage.addNewTodo).sendKeys(t, Keys.ENTER).perform());


        //Tüm yapılacakların üzerini çiz.
        Thread.sleep(1000);
        webUniversityPage.todosList.forEach(t->actions.moveToElement(t).click().perform());

        Thread.sleep(1000);

        //Tüm yapılacakları sil.
     // webUniversityPage.deleteButtonsList.forEach(WebElement::click);
        int i=-1;
        for (WebElement t:webUniversityPage.deleteButtonsList) {
            t.click();
        }
        webUniversityPage.deleteButtonsList.clear();
        System.out.println("deletebutonLisr "+webUniversityPage.deleteButtonsList.size());

        //Tüm yapılacakların silindiğini doğrulayın.
     //   List<WebElement> yoklukList=new ArrayList<>(webUniversityPage.todosList);
     //   yoklukList.forEach(t-> System.out.println(t.getText()));
        List<WebElement> newtodos = webUniversityPage.newtodosWebelement;
        Assert.assertEquals(0,newtodos.size());
    }
}
