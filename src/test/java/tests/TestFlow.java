package tests;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.Properties;

public class TestFlow extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    Properties properties;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, wait);
        registerPage = new RegisterPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        cartPage = new CartPage(driver,wait);
        checkoutPage = new CheckoutPage(driver,wait);

    }

    @Test
    public void t01MyAccountList(){
        homePage.clickMyAccountList();
        homePage.clickRegister();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = properties.getProperty("RegisterLink");
        Assert.assertEquals(actualUrl, expectedUrl, "Registration page is not reachable!\"");
    }
    @Test
    public void tc02RegisterCustomer() {
        registerPage.FillRegisterForm();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = properties.getProperty("LoginLink");
        Assert.assertEquals(actualUrl, expectedUrl, "Login page is not reachable!");
    }
    @Test
    public void tc03Login(){
        driver.get(properties.getProperty("LoginLink"));
        loginPage.fill_loginForm();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = properties.getProperty("LoginSuccessMsg");
        Assert.assertEquals(actualUrl, expectedUrl, "Unsuccessful Login!");
    }
    @Test
public void tc04AddtoCart(){
    driver.get(properties.getProperty("baseUrl"));
    cartPage.AddtoCart();
    String actualUrl = driver.getCurrentUrl();
    String expectedUrl = properties.getProperty("CartLink");
    Assert.assertEquals(actualUrl, expectedUrl, "Unable to open Cart successfully");
}
@Test
public  void tc05CheckOut(){
    driver.get(properties.getProperty("baseUrl"));
    checkoutPage.clickCheckOut();
    String actualUrl = driver.getCurrentUrl();
    String expectedUrl = properties.getProperty("CheckoutLink");
    Assert.assertEquals(actualUrl, expectedUrl, "Unable to processed to checkout  successfully");
}
    }

