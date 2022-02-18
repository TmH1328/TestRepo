
import java.io.IOException;
import java.util.Locale;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bi
 */
public class Main {

    public static void main(String[] args) throws IOException {
        while (true) {
            //display menu
            Manage.displayMenu();
            //ask user to input option
            System.out.print("Please choose one option: ");
            int option = Input.getOption();
            switch (option) {
                case 1:
                    //Use interface language to Vietnamese and perform login
                    Locale localeVN = new Locale("vi","VN");
                    Manage.login(localeVN);
                    break;
                case 2:
                    //Use interface language to English and perform login 
                    Locale localeUS = new Locale("en","US");
                    Manage.login(localeUS);
                    break;
                case 3:
                    //Exit
                    return;
            }
        }
    }
}
