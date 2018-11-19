package Lab06Auto.steps.serenity;

import Lab06Auto.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class LoginSteps {

    LoginPage loginPage;

    @Step
    /**
     *
     */
    public void go_to_login_page() {
        loginPage.open();
    }

    @Step
    public void selectServer(String serverName) {
        loginPage.select_server(serverName);
    }

    @Step
    public void enters_username(String username) {
        loginPage.enters_username(username);
    }

    @Step
    public void enters_password(String password) {
        loginPage.enters_password(password);
    }

    @Step
    public void click_login() {
        loginPage.click_login();
    }

    // pasul de preluare de informatii din login page si dati mai departe catre pagina web
    @StepGroup
    public void login_steps(String serverName, String username, String password) {
        selectServer(serverName);
        enters_username(username);
        enters_password(password);
        click_login();
    }


    @Step
    public void should_see_definition(String definition) {
        assertThat(loginPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void should_see_allert_message(String message, String alert_message) {
        assert message.equals(alert_message);
    }
}