package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalcarsPage {
    public BlueRentalcarsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@role='button'])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='formBasicEmail']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//*[@id='dropdown-basic-button']")
    public WebElement ddm;
}
