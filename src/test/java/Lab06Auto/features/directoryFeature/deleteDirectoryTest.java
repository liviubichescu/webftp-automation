package Lab06Auto.features.directoryFeature;

import Lab06Auto.steps.serenity.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class deleteDirectoryTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public AccountSteps accountSteps;

    @Steps
    public CreateDirectorySteps createDirectorySteps;

    @Steps
    public DeleteDirectorySteps deleteDirectorySteps;
    @Steps
    public NewDirectorySteps newDirSteps;

    @Steps
    public LogoutSteps logoutSteps;

    String dir_name ="ANAareMERE";

    @Issue("#WIKI-1")
    @Test
    public void deleteFolder() {
        loginSteps.go_to_login_page(); // mergem la pagina de login
        loginSteps.login_steps("linux.scs.ubbcluj.ro", "vvta", "vvta2018+");  // executam pasii de adaugare a fieldurilor
        accountSteps.should_be_in_current_directory("/home/scs/others/" + "vvta"); // verificam daca suntem in pagina de account

        //aici completam cu pasii de creeare si verificare a unui director
        createDirectorySteps.click_newDir(); // dam click pe buttonul new dir
        createDirectorySteps.message_for_new_directory("Create new directories"); // verificam daca am trecut la pasul urmator
        createDirectorySteps.enters_newDirectoryName(dir_name); // introducem numele in input field
        createDirectorySteps.click_submitButton();  // dam click pe submit
        // trecem la pagina urmatoare
        newDirSteps.should_see_message("Directory "+dir_name+" was successfully created."); // verificam ca am trecut la pagina urmatoare si ca avem mesaj precum ca folderul sa creat cu succes
        newDirSteps.click_backButton(); // dam click pe back pentru a reveni la pagina de account

        createDirectorySteps.check_directory_creation(dir_name); // verificam daca in pagina de account a aparul noul folder creat

        /** stergem directorul creat */
        deleteDirectorySteps.selectDirectory(dir_name); // selectam directorul de sters
        deleteDirectorySteps.click_delete();    // dam click pe butonul delete
        deleteDirectorySteps.click_submitForDeleteButton(); // dam click pe butonul de ok(submit)
        deleteDirectorySteps.deleted_directory_message("Deleted subdirectory /home/scs/others/vvta/"+dir_name);
        deleteDirectorySteps.click_backButtonInDelete();


        accountSteps.click_logout(); // facem logout
        logoutSteps.should_see_message("You have logged out from the FTP server"); // verificam daca am iesit cu succes

//        pasii din test sunt:
//        1. go to login page   =>facut
//        2. enter data  =>facut
//        3. check if valid login =>facut
//        4. Daca valid login este ok atunci facem click pe new directory
//        5. verificam daca am ajuns pe pagina unde creem noul director
//        6. completam numele directorului
//        7. verificam daca directorul sa creeat cu succes
//        8. revenim la pagina initiala
//        7. verificam daca directorul sa creeat cu succes
    }

} 