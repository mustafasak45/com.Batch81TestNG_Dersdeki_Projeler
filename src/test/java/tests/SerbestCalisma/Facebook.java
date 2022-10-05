package tests.SerbestCalisma;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Facebook {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));

    }
}
