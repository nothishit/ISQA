package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

import pages.LoginPage;

public class LoginTest extends TestBase {
    @Test
    public void testEnterLogin() {
        final String expectedLogin = "vckrick@gmail.com";
        final String expectedPassword = "sdasda321321";

        driver.get("https://users.nexusmods.com/auth/sign_in");
        var loginPage = new LoginPage(driver); // page object
        List<String> actualData = loginPage.enterLogin("vckrick@gmail.com", "sdasda321321");
        Assert.assertEquals(actualData.get(0), expectedLogin);
        Assert.assertEquals(actualData.get(1), expectedPassword);
    }
}
