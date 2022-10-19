package Pages;

import Interfaces.ILogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage implements ILogoutPage {

    @FindBy(id = "react-burger-menu-btn")
    WebElement HomeButton;
    @FindBy(id = "logout_sidebar_link")
    WebElement lout;

    public LogoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void logout(){
        HomeButton.click();
        lout.click();
    }
}
