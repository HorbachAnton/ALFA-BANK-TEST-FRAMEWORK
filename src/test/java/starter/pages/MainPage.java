package starter.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;

public class MainPage extends PageObject
{
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Вход в Alfa-Test выполнен')]")
    private WebElement titleLabel;

    public MainPage(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    public boolean isDisplayed()
    {
        return titleLabel.isDisplayed();
    }
}
