package Lab06Auto.steps.serenity;

import Lab06Auto.pages.DeleteDirectoryPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class DeleteDirectorySteps {

    DeleteDirectoryPage deleteDirectoryPage;

    @Step
    public void selectDirectory(String directory) {
        deleteDirectoryPage.select_directory_checkbox(directory);
    }

    @Step
    public void click_delete() {
        deleteDirectoryPage.click_delete_button();
    }


    @Step
    public void click_submitForDeleteButton() {
        deleteDirectoryPage.click_submitForDelete();
    }

    @Step
    public void deleted_directory_message(String message) {
        assertThat(deleteDirectoryPage.get_deleted_message(), hasItem(containsString(message)));
    }

    @Step
    public void click_backButtonInDelete() {
        deleteDirectoryPage.click_backButtonDelete();
    }

}