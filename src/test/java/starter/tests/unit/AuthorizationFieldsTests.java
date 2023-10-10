package starter.tests.unit;

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

@ExtendWith(SerenityJUnit5Extension.class)
public class AuthorizationFieldsTests {

    @CastMember
    Actor actor;

    @BeforeEach
    void preSteps()
    {
        actor.attemptsTo(AppActivation.closeApp());
        actor.attemptsTo(AppActivation.openApp());
    }

    @Test
    @DisplayName("Shouldn't be able to enter more than 50 characters in the login field.")
    void characterLimitOfAuthorizationFields() {
        actor.attemptsTo(
            UserAuthorization.fillLogin("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"),
            UserAuthorization.fillPassword("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"),
            Ensure.that(LoginPageState.numberOfCharactersEnteredInLoginField()).isEqualTo(50),
            Ensure.that(LoginPageState.numberOfCharactersEnteredInPasswordField()).isEqualTo(50));
    }


    @Test
    @DisplayName("Should be able to show and hide a password.")
    void showAndHidePassword() {
        actor.attemptsTo(
            UserAuthorization.fillPassword("Pass"),
            Ensure.that(LoginPageState.passwordHideStatus()).isTrue(),
            UserAuthorization.showPassword(),
            Ensure.that(LoginPageState.passwordHideStatus()).isFalse(),
            UserAuthorization.hidePassword(),
            Ensure.that(LoginPageState.passwordHideStatus()).isTrue());
    }

    @AfterEach
    void afterSteps()
    {
        actor.attemptsTo(AppActivation.closeApp());
    }
}
