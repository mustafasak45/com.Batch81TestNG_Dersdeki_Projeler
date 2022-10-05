package tests.Practice.practice07;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import pages.WebUniversityPageHocaninCozumu;
import utilities.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P01HocaninCozumu {
    // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
    // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
    //Tüm yapılacakların üzerini çiz.
    //Tüm yapılacakları sil.
    //Tüm yapılacakların silindiğini doğrulayın.
    //EXPLORATORY testing
    @Test
    public void test01() throws InterruptedException {
        WebUniversityPageHocaninCozumu webUniversityPageHocaninCozumu=new WebUniversityPageHocaninCozumu();

        //  // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");



        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
       // WebUniversityPageHocaninCozumu webUniversityPageHocaninCozumu=new WebUniversityPageHocaninCozumu();

        //Buradaki listeyi yapılacaklar listesine tek tek manuel olarak eklemek yerine toplu olarak bir loop kullanarak gönderebilmek
        //amacı ile biz olusturduk
        List<String> worklist = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka", "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));
        Actions actions = new Actions(Driver.getDriver());
        for (String w : worklist) {
            actions.click(webUniversityPageHocaninCozumu.adNewTodo).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }
        Thread.sleep(2000);

        System.out.println("todosWebelement.size "+webUniversityPageHocaninCozumu.todosWebelement.size());
        System.out.println("newtodosWebelement.size "+webUniversityPageHocaninCozumu.newtodosWebelement.size());

        //Tüm yapılacakların üzerini çiz.
        List<WebElement> todos = webUniversityPageHocaninCozumu.todosWebelement;
        for (WebElement w : todos) {
            w.click();
        }
        Thread.sleep(2000);

        //Tüm yapılacakları sil.
        List<WebElement> deleteButtons = webUniversityPageHocaninCozumu.deleteButtonsWebelement;
        for (WebElement w : deleteButtons) {
            w.click();
        }
        Thread.sleep(2000);

        //Tüm yapılacakların silindiğini doğrulayın.
        List<WebElement> newtodos = webUniversityPageHocaninCozumu.newtodosWebelement;
        Assert.assertEquals(0,newtodos.size());
    }
}
