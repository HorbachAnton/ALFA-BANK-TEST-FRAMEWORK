package starter.questions.pages;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;
import starter.pages.LoginPage;

public class LoginPageState
{
   public static Question<Boolean> loginPageDisplayStatus()
   {
      return Question.about("a display status of the main page").answeredBy((actor) ->
         {
            var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
            return loginPage.isDisplayed();
         });
   }

   public static Question<Boolean> wrongCredentialsMessageDisplayStatus()
   {
      return Question.about("a display status of the wrong credentials message").answeredBy((actor) ->
         {
            var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
            return loginPage.isWrongCredentialMessageDisplayed();
         });
   }

   public static Question<Integer> numberOfCharactersEnteredInLoginField()
   {
      return Question.about("number of characters entered in login field").answeredBy((actor) ->
         {
            var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
            return loginPage.getTextFromLoginField().length();
         });
   }

   public static Question<Integer> numberOfCharactersEnteredInPasswordField()
   {
      return Question.about("number of characters entered in password field").answeredBy((actor) ->
         {
            var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
            return loginPage.getTextFromPasswordField().length();
         });
   }

      public static Question<Boolean> passwordHideStatus()
   {
      return Question.about("a hide status of a pasword").answeredBy((actor) ->
         {
            var loginPage = new LoginPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
            return Boolean.parseBoolean(loginPage.getPasswordFieldAttribute("password"));
         });
   }
}
