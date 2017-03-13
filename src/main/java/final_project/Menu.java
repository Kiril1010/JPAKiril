package final_project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Scanner;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    static RubricService rubricService = new RubricService();

    public void getMenu() {
        Scanner scannerMenu = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to add new rubric");
        System.out.println("Enter 2 to add new advertisement");
        String key = scannerMenu.nextLine();
        while (true) {
            switch (key) {
                case "1": {
                    System.out.println("Enter the name of rubric");
                    String nameRubric = scanner.nextLine();
                    rubricService.addRubric(nameRubric);
                    break;
                }
                case "2": {
                    System.out.println("Enter the name of advertisement");
                    String nameAdvertisement = scanner.nextLine();
                    rubricService.addRubric(nameAdvertisement);
                    break;
                }
            } break;
        }
    }
}
