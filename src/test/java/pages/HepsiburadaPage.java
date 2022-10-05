package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HepsiburadaPage {
    public HepsiburadaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[@class='sf-MenuItems-UHHCg2qrE5_YBqDV_7AC'])[1]")
    public WebElement elektronik;


    @FindBy(xpath = "(//*[@href='https://www.hepsiburada.com/bilgisayarlar-c-2147483646'])[1]")
    public WebElement bilgisayarTablet;

    @FindBy(xpath = "(//div[@class='sf-ChildMenuItems-OMxRJDk0466HYQpTli0P'])[1]//ul//li//ul//li//a//span")
    public List<WebElement> anaveAltBasliklar;

}
