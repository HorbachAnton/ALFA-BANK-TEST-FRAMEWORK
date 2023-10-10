package starter.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;

public class LoginPage extends PageObject
{
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id, 'tvTitle')]")
    private WebElement titleLabel;
    
    @AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id, 'etUsername')]")
    private WebElement usernameField;

    @AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id, 'etPassword')]")
    private WebElement passwordField;

    @AndroidFindBy(xpath="//android.widget.ImageButton[contains(@resource-id, 'text_input_end_icon')]")
    private WebElement showPasswordButton;

    @AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id, 'btnConfirm')]")
    private WebElement loginButton;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id, 'com.alfabank.qapp:id/tvError') and contains(@text, 'Введены неверные данные')]")
    private WebElement wrongCredentialsLabel;

    public LoginPage(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    public String getTitle()
    {
        return titleLabel.getText();
    }

    public void fillLogin(String login)
    {
        usernameField.sendKeys(login);
        ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).hideKeyboard();
    }

    public void fillPassword(String password)
    {
        passwordField.sendKeys(password);
        ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver()).hideKeyboard();
    }

    public String getPasswordFieldAttribute(String attribute)
    {
        return passwordField.getAttribute(attribute);
    }


    public String getTextFromLoginField()
    {
        return usernameField.getText().trim();
    }

        public String getTextFromPasswordField()
    {
        return passwordField.getText().trim();
    }

    public void logInto()
    {
        loginButton.click();
    }

    public boolean isDisplayed()
    {
        return loginButton.isDisplayed();
    }

    public boolean isWrongCredentialMessageDisplayed()
    {
        return wrongCredentialsLabel.isDisplayed();
    }

    public void ClickShowPassword()
    {
        if(Boolean.parseBoolean(getPasswordFieldAttribute("password")))
        {
            showPasswordButton.click();
        }
        
    }

    public void ClickHidePassword()
    {
        if(!Boolean.parseBoolean(getPasswordFieldAttribute("password")))
        {
            showPasswordButton.click();
        }
    }
}