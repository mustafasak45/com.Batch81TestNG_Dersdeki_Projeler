package tests.SerbestCalisma;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class TrendYol {
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));
    }
}
