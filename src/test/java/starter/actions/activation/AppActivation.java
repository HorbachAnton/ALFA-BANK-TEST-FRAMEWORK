package starter.actions.activation;

import io.appium.java_client.InteractsWithApps;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;

public class AppActivation {
    public static Performable openApp()
    {
        return Task.where("{0} open the app.", actor -> { ((InteractsWithApps)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()).activateApp("com.alfabank.qapp"); } );
    }

    public static Performable closeApp()
    {
        return Task.where("{0} close the app.", actor -> { ((InteractsWithApps)((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver()).terminateApp("com.alfabank.qapp"); } );
    }
}
