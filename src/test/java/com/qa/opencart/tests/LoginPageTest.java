package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNavigationTest() {
        loginPage = homePage.navigateLoginButton();
        String actLoginPage = loginPage.getLoginPageTitle();
        Assert.assertEquals(actLoginPage, AppConstants.LOGIN_PAGE_TITLE, "Login page title mismatch.");
    }

    @Test(priority = 2)
    public void forgotPwdLinkExistsTest() {
        boolean isForgotLinkExists = loginPage.isForgotPasswordExists();
        Assert.assertTrue(isForgotLinkExists, "Forgot did not exists.");
    }

    @Test(priority = 3)
    public void appLoginTest() {
        boolean isLoginSuccess = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        Assert.assertTrue(isLoginSuccess, "Login is not successful.");
    }
}
