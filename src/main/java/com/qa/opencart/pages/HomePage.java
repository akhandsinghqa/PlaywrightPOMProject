package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    // String Locators -- Page repository

    private final String search = "input[placeholder='Search']";
    private final String searchIcon = "div#search button";
    private final String searchPageHeader = "div#content h1";

    // Page Constructor

    public HomePage(Page page) {
        this.page = page;
    }

    // Page actions/methods

    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("page title : " + title);
        return title;
    }

    public String getHomePageURL() {
        String url = page.url();
        System.out.println("page url : " + url);
        return url;
    }

    public String doSearch(String productName) {
        page.waitForLoadState();
        page.locator(search).fill(productName);
        page.locator(searchIcon).click();
        String searchHeader = page.locator(searchPageHeader).textContent();
        System.out.println("Search Header : " + searchHeader);
        return searchHeader;
    }

}
