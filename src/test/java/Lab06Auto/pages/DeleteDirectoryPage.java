package Lab06Auto.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

// pagina pentru a verifica daca suntem pe pagina cu "Create new directories"
public class DeleteDirectoryPage extends PageObject {

    @FindBy(id="maintable")
    private WebElementFacade table;

    public void select_directory_checkbox(String directory) {
        selectDirectoryByValue(table,"value",directory);
    }

    // metoda care permite sa selectezi un element din lista
    public void selectDirectoryByValue(WebElementFacade el, String attribute, String value) {
        List<WebElement> list  = el.findElements(By.tagName("input"));

        for (int i=0; i<list.size(); i++){
            String dir = list.get(i).getAttribute(attribute);
            if (dir.equalsIgnoreCase(value)){
                list.get(i).click();
                break;
            }
        }
    }

    // click pe butonul de delete
    @FindBy(id="BrowseForm")
    private WebElementFacade deleteButton;

    public void click_delete_button() {
        selectDeleteButtonByValue(deleteButton,"value","Delete");
    }

    // metoda care permite sa selectezi un element din lista
    public void selectDeleteButtonByValue(WebElementFacade el, String attribute, String value) {
        List<WebElement> list  = el.findElements(By.tagName("input"));

        for (int i=0; i<list.size(); i++){
            String dir = list.get(i).getAttribute(attribute);
            if (dir.equalsIgnoreCase(value)){
                list.get(i).click();
                break;
            }
        }
    }

    // facem click pe submit(ok)
    @FindBy(xpath="//*[@id=\"CopyMoveDeleteForm\"]/a[2]/img")
    private WebElementFacade submitDeleteButton;

    public void click_submitForDelete() {
        submitDeleteButton.click();
    }

    // verificam daca folderul se afiseaza mesajul precum ca folderul s-a sters cu succes
    public List<String> get_deleted_message() {
        WebElementFacade definitionList = find(By.tagName("ul"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }


    // facem click pe back dupa delete folder
    @FindBy(xpath="//*[@id=\"CopyMoveDeleteForm\"]/a/img")
    private WebElementFacade clickBackButton;

    public void click_backButtonDelete() {
        clickBackButton.click();
    }


}