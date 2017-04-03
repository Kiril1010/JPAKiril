//package final_project;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.util.Scanner;
//
//@Entity
//public class Menu {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    static RubricService rubricService = new RubricService();
//
//    public void getMenu() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter 1 to add new rubric");
//        System.out.println("Enter 2 to add new advertisement");//extra
//        String key = scanner.nextLine();
//        while (true) {
//            switch (key) {
//                case "1": {
//                    System.out.println("Enter the name of rubric");
//                    String nameRubric = scanner.nextLine();
//                    Rubric rubric = new Rubric(nameRubric);
//                    rubricService.addRubric(rubric);
//                    rubricService.save(rubric);
//                    break;
//                }
//                case "2": {
//                    System.out.println("Enter the name of advertisement");
//                    String nameAdvertisement = scanner.nextLine();
//                    //rubricService.addRubric(nameAdvertisement);
//                    break;
//                }
//            } break;
//        }
//    }
//}
