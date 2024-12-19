package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(css = "input[placeholder='E-Mail Address']")
    public WebElement emailAddress;

    @FindBy(css = "input[placeholder='Password']")
    public WebElement password;

    @FindBy(css = "a[href*='route=account/forgotten']")
    public WebElement forgetPassword;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Login')]")
    public WebElement loginBtn;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
    public void fill_loginForm(){
        emailAddress.sendKeys("en@test.com");
        password.sendKeys("1234");
        loginBtn.click();
    }
}
