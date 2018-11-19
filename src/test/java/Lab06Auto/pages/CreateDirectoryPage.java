package Lab06Auto.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

// pagina pentru a verifica daca suntem pe pagina cu "Create new directories"
public class CreateDirectoryPage extends PageObject {

    @FindBy(xpath="//*[@id=\"smallbutton\"]")
    private WebElementFacade newDirButton;

    public void click_newDirectory() {
        newDirButton.click();
    }

    @FindBy(xpath="//*[@id=\"content\"]/div[2]/h1") // ne uitam in pagina cu inspect element la "nume" sau xpath si il identificam
    private WebElementFacade currentDirectory;

    public String get_current_directory_name(){
        return currentDirectory.getValue();
    }

    @FindBy(name="newNames[1]") // ne uitam in pagina cu inspect element la "nume" si il identificam
    private WebElementFacade directory1;

    public void enters_directory1_name(String directory1_name) {
        directory1.type(directory1_name);
    }


    @FindBy(xpath="//*[@id=\"NewDirForm\"]/a[2]/img")
    private WebElementFacade submitButton;

    public void click_submit() {
        submitButton.click();
    }


    public List<String> getTextForNewDirectory() {
        WebElementFacade definitionList = find(By.tagName("div"));
        return definitionList.findElements(By.tagName("h1")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

    public List<String> getTextDirectoryCreationSuccesful() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("a")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

}