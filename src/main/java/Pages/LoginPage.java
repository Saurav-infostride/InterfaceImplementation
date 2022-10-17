package Pages;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;


public class LoginPage extends Test.TestBase implements Interfaces.LoginPage{

    @FindBy(id = "user-name")
    WebElement uname;
    @FindBy(id = "password")
    WebElement pass;
    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login() throws IOException {

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//TestData//Login_Data.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheetAt(0);
        String username = sheet.getRow(1).getCell(0).getStringCellValue();
        String password = sheet.getRow(1).getCell(1).getStringCellValue();
        uname.sendKeys(username);
        pass.sendKeys(password);
        loginBtn.click();
    }

    public void verifySuccessfulLogin()
    {
        Assert.assertEquals(driver.getCurrentUrl(), "");
    }
}
