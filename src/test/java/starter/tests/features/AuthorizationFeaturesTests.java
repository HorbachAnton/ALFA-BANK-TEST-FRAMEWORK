package starter.tests.features;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.actions.activation.AppActivation;
import starter.actions.authorization.UserAuthorization;
import starter.questions.pages.LoginPageState;
import starter.questions.pages.MainPageState;

@ExtendWith(SerenityJUnit5Extension.class)
 public class AuthorizationFeaturesTests {

    @CastMember
    Actor actor;

    @BeforeEach
    void preSteps()
    {
        actor.attemptsTo(AppActivation.closeApp());
        actor.attemptsTo(AppActivation.openApp());
    }

    @Test
    @DisplayName("Should be able to log into the app")
    void logIntoApp() {
        actor.attemptsTo(
            Ensure.that(LoginPageState.loginPageDisplayStatus()).isTrue(),
            UserAuthorization.logInto("Login", "Password"),
            Ensure.that(MainPageState.mainPageDisplayStatus()).isTrue());
    }

    @Test
    @DisplayName("Shouldn't be able to log into the app with invalid credentials")
    void logIntoAppWithInvalidCredentials()
    {
        actor.attemptsTo(
            UserAuthorization.logInto("Log", "Pass"),
            Ensure.that(LoginPageState.wrongCredentialsMessageDisplayStatus()).isTrue());
    }

    @Test
    @DisplayName("Shouldn't be able to log into the app without credentials.")
    void logIntoAppWithoutCredentials()
    {
        actor.attemptsTo(
            UserAuthorization.logInto(),
            Ensure.that(LoginPageState.wrongCredentialsMessageDisplayStatus()).isTrue());
    }

    @AfterEach
    void afterSteps()
    {
        actor.attemptsTo(AppActivation.closeApp());
    }
}
