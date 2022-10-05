package tests.day20_SmokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class SerbestCalisma {
    @Test
    public void test1() {
//        !-- https://www.saucedemo.com/ odevi-test data
//        saucedemoUrl=https://www.saucedemo.com/
//        saucedemoUsername=standard_user
//        saucedemoPassword=secret_sauce
        Driver.getDriver().get(ConfigReader.getProperty("sauceUrl"));
        SaucedemoPage saucedemoPage=new SaucedemoPage();
        Actions actions=new Actions(Driver.getDriver());

        saucedemoPage.userNameTextBox.sendKeys(ConfigReader.getProperty("userNameSauce"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("passwordSauce")).sendKeys(Keys.ENTER).perform();

    }
}
