package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Register Account']")
    public WebElement registerAccountHeading;

    @FindBy(id = "input-firstname")
    public WebElement firstName;

    @FindBy(id = "input-lastname")
    public WebElement lastName;

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(id = "input-password")
    public WebElement password;

    @FindBy(css = "input.form-check-input[name='agree']")
    public WebElement checkbox;

    @FindBy(css = "button[type='submit']")
    public WebElement continueBtn;


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
    public void FillRegisterForm(){
        wait.until(ExpectedConditions.visibilityOf(firstName));
        scrollToBottom(driver);
        firstName.sendKeys("FirstName");
        lastName.sendKeys("LastName");
        email.sendKeys("Email");
        password.sendKeys("Password");
        checkbox.click();
        continueBtn.click();
        wait.until(ExpectedConditions.attributeToBe(continueBtn, "disabled", ""));
    }
}
