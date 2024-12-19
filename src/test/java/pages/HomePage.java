package pages;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

   // @FindBy(xpath = "//i[contains(@class, 'fa-solid') and contains(@class, 'fa-user')]")
    @FindBy(xpath = "//a[@class='dropdown-toggle' and @data-bs-toggle='dropdown']")
    public WebElement myAccountList;

    @FindBy(css = "a.dropdown-item[href*='route=account/register']")
    public WebElement register;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void clickMyAccountList() {
        wait.until(ExpectedConditions.visibilityOf(myAccountList));
        myAccountList.click();
    }

    public void clickRegister() {
        wait.until(ExpectedConditions.visibilityOf(register));
        register.click();
    }
}
