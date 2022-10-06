package tests.day21_ReusebleMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

        ArrayList<String> liste =new ArrayList<>(Driver.getDriver().getWindowHandles());

        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().window(liste.get(0));
        ReusableMethods.switchToWindow("New Window");

    }
}
