import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice  = -1;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        ListController<Student> controller = new ListController<>();
        File file = new File("Teacher.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        controller.readFile("Teacher.txt");
        while (choice != 0) {
            System.out.println("_________");
            System.out.println("1.ADD");
            System.out.println("2.DISPLAY");
            System.out.println("3.REMOVE");
            System.out.println("4.EDIT");
            System.out.println("5.SEARCH");
            System.out.println("6.SORT BY ID");
            System.out.println("7.SAVE");
            System.out.println("_________");
            System.out.print("Select: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    controller.add(new Student());
                    break;
                case 2:
                    controller.display();
                    break;
                case 3:
                    System.out.print("Enter remove id: ");
                    int removeId = scanner1.nextInt();
                    controller.remove(removeId);
                    break;
                case 4:
                    System.out.print("Enter edit id: ");
                    int editId = scanner1.nextInt();
                    controller.edit(editId);
                    break;
                case 5:
                    System.out.print("Enter search id: ");
                    int searchId = scanner1.nextInt();
                    controller.searchById(searchId);
                    break;
                case 6:
                    controller.sortedById();
                    break;
                case 7:
                    controller.saveFile("Teacher.txt");
                    break;
            }
        }
    }
}