package Lab06Auto.steps.serenity;

import Lab06Auto.pages.CreateDirectoryPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class CreateDirectorySteps {

    CreateDirectoryPage createDirectoryPage;

    @Step
    public void click_newDir() {
        createDirectoryPage.click_newDirectory();
    }

    @Step
    public void message_for_new_directory(String message) {
        assertThat(createDirectoryPage.getTextForNewDirectory(), hasItem(containsString(message)));
    }

    @Step
    public void check_directory_creation(String message) {
        assertThat(createDirectoryPage.getTextDirectoryCreationSuccesful(), hasItem(containsString(message)));
    }

    @Step
    public void enters_newDirectoryName(String dirName) {
        createDirectoryPage.enters_directory1_name(dirName);
    }

    @Step
    public void click_submitButton() {
        createDirectoryPage.click_submit();
    }


}