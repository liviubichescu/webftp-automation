package Lab06Auto.features.login.invalid;

import Lab06Auto.steps.serenity.AccountSteps;
import Lab06Auto.steps.serenity.LoginSteps;
import Lab06Auto.steps.serenity.LogoutSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginEmptyUserNameTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public AccountSteps accountSteps;

    @Steps
    public LogoutSteps logoutSteps;

    @Issue("#WIKI-1")
    @Test
    public void valid_login() {
        loginSteps.go_to_login_page();
        loginSteps.login_steps("linux.scs.ubbcluj.ro", "", "vvta2018+");
        // incercam sa ne logam fara adaugam un user
        String msg = webdriver.switchTo().alert().getText(); // face switch la alerta aparuta si luam mesajul
        loginSteps.should_see_allert_message(msg, "Please enter a username.");

        webdriver.switchTo().alert().accept(); // apasam ok pe alert

        // reintroducem pasii corecti
        loginSteps.login_steps("linux.scs.ubbcluj.ro", "vvta", "vvta2018+");
        accountSteps.should_be_in_current_directory("/home/scs/others/" + "vvta");

        accountSteps.click_logout();
        logoutSteps.should_see_message("You have logged out from the FTP server");


    }

} 