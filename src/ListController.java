import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListController<E extends Person> {
    private List<E> list;
     public ListController() {
         this.list = new ArrayList<>();
    }
    public void add(E e) {
         e.scanner();
         list.add(e);
    }
    public void display() {
         this.list.forEach(System.out::println);
    }
    public void remove(int id) {
         list.removeIf(person->person.getId() == id);
//        for (E item: list) {
//            if (item.getId() == id) {
//                list.remove(item);
//                break;
//            }
//        }


//         list.forEach(e -> {
//             if (e.getId() == id) {
//                 list.remove(e);
//             }
//         });
    }

    public void searchById(int id) {
         List<E> list1;
         list1 = list.stream().filter(E-> E.getId() == id).collect(Collectors.toList());
         if (list1.isEmpty()) {
             System.out.println("Not found");
         } else {
             list1.forEach(System.out::println);
         }
//         boolean found = false;
//         for (E item: list) {
//            if (item.getId() == id) {
//                found = true;
//                System.out.println(item);
//            }
//         }
//         if (found == false) {
//             System.out.println("Not found");
//         }
    }

    public void edit(int id) {
        for (E item: list) {
            if (item.getId() == id) {
                item.scanner();
                break;
            }
        }
    }
    public void sortedById() {
         list = list.stream().sorted(Comparator.comparing(E::getId)).collect(Collectors.toList());
    }
    public void saveFile(String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
//            for (E e : list) {
//                String line = e.toString();
//                byte[] b = line.getBytes("utf8");
//                fos.write(b);
//            }
//            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readFile(String fileName) {
         FileInputStream fis = null;
         try {
             fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis);
             this.list = (List) ois.readObject();
             ois.close();
         } catch (FileNotFoundException e) {
             System.err.println("File not found");
         } catch (EOFException e) {
             System.err.println(e.toString());

         } catch (IOException e) {
             System.err.println(e.toString());
         } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }

    }
}
