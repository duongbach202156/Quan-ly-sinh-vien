import java.util.Scanner;

public class Student extends Person{
    private int age;
    public Student() {

    }
    public Student(String name, int id, int age) {
        super(name,id);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student {Name= " + super.getName()  + ", id=" + super.getId() + ", age=" + age + "}";
    }
    public void scanner() {
        super.scanner();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age:");
        this.age = scanner.nextInt();
        while (age < 0) {
            System.out.println("Age cannot negative");
            System.out.print("Enter age:");
            this.age = scanner.nextInt();
        }
    }
}
