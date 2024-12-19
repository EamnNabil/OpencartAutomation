package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://demo.opencart.com/en-gb?route=checkout/checkout']")
    public WebElement checkoutBtn;


    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
    public void clickCheckOut(){
        checkoutBtn.click();
    }
}
