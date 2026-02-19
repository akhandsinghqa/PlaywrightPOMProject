package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    private final String emailAddress = "input#input-email";
    private final String password = "input#input-password";
    private final String loginButton = "input[value='Login']";
    private final String forgotPasswordLink = "a:text('Forgotten Password')";
    private final String logoutLink = "#account-account a:has-text('Logout')";

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageTitle() {
        String title = page.title();
        System.out.println("Login Page Title : " + title);
        return title;
    }

    public boolean isForgotPasswordExists() {
        boolean isExists = page.isVisible(forgotPasswordLink);
        System.out.println(" Is forgotten password link exist : " + isExists);
        return isExists;
    }

    public boolean doLogin(String appUserName, String appPassword) {
        System.out.println("UserName : " + appUserName + " Password : " + appPassword);
        page.locator(emailAddress).fill(appUserName);
        page.locator(password).fill(appPassword);
        page.locator(loginButton).click();
        page.locator(logoutLink).waitFor();
        if (page.locator(logoutLink).isVisible()) {
            System.out.println("user is successfully logged in...");
            return true;
        } else {
            System.out.println("user login is unsuccessful.");
            return false;
        }
    }

}
