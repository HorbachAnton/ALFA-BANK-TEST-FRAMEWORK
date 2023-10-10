package starter.questions.pages;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;
import starter.pages.MainPage;

public class MainPageState
{
   public static Question<Boolean> mainPageDisplayStatus()
   {
      return Question.about("a display status of the main page").answeredBy((actor) ->
         {
            var mainPage = new MainPage(((AppiumDriver)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()));
            return mainPage.isDisplayed();
         });
   }
}