package starter.actions.authorization;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;
import starter.pages.LoginPage;

public class UserAuthorization
{
    public static Performable logInto(String username, String password)
    {
        return Task.where(String.format("{0} logs into the app. The used username: %s.", username), actor ->
            {
                var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
                loginPage.fillLogin(username);
                loginPage.fillPassword(password);
                loginPage.logInto();
            });
    }

    public static Performable logInto()
    {
        return Task.where("{0} logs into the app.", actor ->
            {
                var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
                loginPage.logInto();
            });
    }

    public static Performable fillLogin(String username)
    {
        return Task.where(String.format("{0} fill the login field. The used username: %s.", username), actor ->
            {
                var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
                loginPage.fillLogin(username);
            });
    }

    public static Performable fillPassword(String password)
    {
        return Task.where("{0} fill the password field.", actor ->
            {
                var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
                loginPage.fillPassword(password);
            });
    }

    public static Performable showPassword()
    {
        return Task.where("{0} click on a button to show a password.", actor ->
            {
                var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
                loginPage.ClickShowPassword();
            });
    }

    public static Performable hidePassword()
    {
        return Task.where("{0} click on a button to hide a password.", actor ->
            {
                var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
                loginPage.ClickHidePassword();
            });
    }
}
