package Pages;

import Interfaces.ILoginPage;
import Interfaces.ILogoutPage;
import org.openqa.selenium.WebDriver;
import static Test.TestBase.driver;


public class PageFactory {

    private LoginPage loginPage;
    private LogoutPage logoutPage;

    public PageFactory(WebDriver driver)
    {
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    public ILoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public ILogoutPage getLogoutPage() {
        if (logoutPage == null) {
            logoutPage = new LogoutPage(driver);
        }
        return logoutPage;
    }
}
