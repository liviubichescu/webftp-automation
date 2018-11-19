package Lab06Auto.steps.serenity;

import Lab06Auto.pages.AccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class AccountSteps {

    AccountPage accountPage;

    @Step
    public void click_logout() {
        accountPage.click_logout();
    }

    @Step
    public void should_be_in_current_directory(String currentDirectory) {
        assert(accountPage.get_current_directory_name().equals(currentDirectory));
    }
}