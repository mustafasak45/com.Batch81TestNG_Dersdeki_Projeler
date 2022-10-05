package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrendYolPage {
    public TrendYolPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='KABUL ET']")
    public WebElement cookiesAcceptButton;

    @FindBy(xpath = "(//*[text()='Giriş Yap'])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='login-button']")
    public WebElement loginButton2;

    @FindBy(xpath = "//*[@id='login-email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//*[text()='E-posta adresiniz ve/veya şifreniz hatalı.']")
    public WebElement passwordWrong;
}
