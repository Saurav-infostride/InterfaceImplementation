package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Test.TestBase.driver;


public class PageDemo {

    private LoginPage loginPage;
    private LogoutPage logoutPage;

    public PageDemo(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public LogoutPage getLogoutPage() {
        if (logoutPage == null) {
            logoutPage = new LogoutPage(driver);
        }
        return logoutPage;
    }
}
