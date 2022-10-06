package tests.day21_ReusebleMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class tekrar {
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Click Here butonuna basın.
    // acilan yeni tab'in title'inin "New Window" oldugunu test edin


    @Test
    public void test01() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=Driver.getDriver().findElement(By.xpath("//*[.='Click Here']"));
        clickHere.click();
        List<String> liste=Driver.getDriver().getWindowHandles().stream().toList();
        Driver.getDriver().switchTo().frame(liste.get(0));
    }
}
