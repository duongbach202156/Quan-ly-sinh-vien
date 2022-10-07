import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
    private String name;

    private int id;
    public Person() {
        // TODO Auto-generated constructor stub
    }
    public Person(String name, int id) {
        super();
        this.name = name;
        this.id = id;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "[name=" + name + ", id=" + id + "]" ;
    }
    public void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name:");
        this.name = scanner.nextLine();
        System.out.print("Enter id:");
        this.id = scanner.nextInt();
    }
}