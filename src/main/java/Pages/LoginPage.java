package Pages;

import Interfaces.ILoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage extends Test.TestBase implements ILoginPage {

    @FindBy(id = "user-name")
    WebElement uname;
    @FindBy(id = "password")
    WebElement pass;
    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginIntoApplication() {
        uname.sendKeys(prop.getProperty("username"));
        pass.sendKeys(prop.getProperty("password"));
        loginBtn.click();
    }

    public void verifySuccessfulLogin()
    {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }


}
