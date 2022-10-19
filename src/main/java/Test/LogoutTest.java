package Test;

import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutTest extends TestBase {

    @Test
    public void logout() throws IOException {
        pageFactory.getLoginPage().loginIntoApplication();
        pageFactory.getLogoutPage().logout();
    }
}
