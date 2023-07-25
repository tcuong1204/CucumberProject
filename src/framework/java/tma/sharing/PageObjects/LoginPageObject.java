package tma.sharing.PageObjects;

import tma.sharing.Utils.ElementHandler;

import java.util.NoSuchElementException;

public class LoginPageObject {

    private static String usernameLocator = "//input[@id='user-name']";
    private static String passwordLocator = "//input[@id='password']";
    private static String loginButtonLocator = "//input[@id='login-button']";
    private static String cartIconLocator = "//*[@class='shopping_cart_link']";
    private static String errorMsgLocator = "//*[@class='error-message-container error']";


    public static void enterUsername(String username) {
        ElementHandler.enterText(usernameLocator, username);
    }

    public static void enterPassword(String password) {
        ElementHandler.enterText(passwordLocator, password);
    }

    public static void clickLoginButton() {
        ElementHandler.clickButton(loginButtonLocator);
    }

    public static void validateLoginSuccess() {
        boolean result = ElementHandler.elementIsDisplayed(cartIconLocator);
        if (result) {
            System.out.println("User is logged to application as expected");
        } else {
            throw new NoSuchElementException("No found cart icon, user is not successfully logged to application");
        }
    }

    public static void validateLoginFail() {
        String textDisplayed = ElementHandler.getDisplayText(errorMsgLocator);
        if (textDisplayed.contains("do not match any user")) {
            System.out.println("User is not logged to application as expected");
        } else {
            throw new NoSuchElementException("Not found error message, user is successfully logged to application not as expected");
        }
    }


}
