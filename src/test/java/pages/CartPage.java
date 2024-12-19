package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
    @FindBy(xpath = "//button[@formaction='https://demo.opencart.com/en-gb?route=checkout/cart.add']")
    public WebElement addToCartBtn;

    @FindBy(xpath ="//a[@href='https://demo.opencart.com/en-gb?route=checkout/cart']" )
    public WebElement viewCartBtn;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueBtn;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
    public void AddtoCart(){
        waitUntilPageLoad();
        BasePage.scrollToElement(addToCartBtn);
        addToCartBtn.click();
        BasePage.scrollToTop();
        viewCartBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
    }
}
