package tests.SerbestCalisma;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Amazon {
    @Test(groups = "grup1")
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        //Driver.getDriver().close();
    }
}
