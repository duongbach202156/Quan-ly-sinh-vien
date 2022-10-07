import java.util.Scanner;

public class Teacher extends Person{
    private String subject;
    public Teacher() {}

    public Teacher(String name, int id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher {Name= " + super.getName()  + ", id=" + super.getId() + ", subject=" + subject + "}";
    }
    public void scanner() {
        super.scanner();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter subject:");
        this.subject = scanner.nextLine();
    }
}
