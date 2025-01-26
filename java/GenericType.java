import java.util.ArrayList;

public class GenericType {

    // Generic Class
    public class Box<T> {
        private T item;

        public T getItem() {
            return this.item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }

    // Generic Method
    public static class Utility {
        public static <T> void printArray(T[] array) {
            for (T element : array) {
                System.out.print(element + " ");
            }
        }
    }

    // Generic Interface
    /*
     * it's an interesting and sometimes subtle aspect of Java! Even if you don’t explicitly use the static keyword, any interface declared inside a class is implicitly static by definition.

    This means you can reference it without creating an instance of the enclosing class, and it behaves independently of any specific instance of the outer class.
     */
    public interface InnerGenericType<T> {
        void save(T entity);

        T findByIndex(int id);
    }

    public class Utilisateur {
        private int id;
        private String username;

        public Utilisateur() {
        }

        public String getUsername() {
            return this.username;
        }

        public int getId() {
            return this.id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public class UserRepository implements InnerGenericType<Utilisateur> {

        ArrayList<Utilisateur> userRepository = new ArrayList<>();

        @Override
        public void save(Utilisateur user) {
            this.userRepository.add(user);
        }

        @Override
        public Utilisateur findByIndex(int id) {
            return this.userRepository.get(id);
        }
    }

    // Main Method
    public static void main(String[] args) {
        // We need outer class in order to instantiate a inner class that is not static
        GenericType outerInstance = new GenericType();
        // Generic Box that can hold String
        Box<String> stringBox = outerInstance.new Box<>();

        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem());

        // Use Integer as type paramaeter
        Box<Integer> integerBox = outerInstance.new Box<>();
        integerBox.setItem(4321);
        System.out.println(integerBox.getItem());

        // Generic Method
        String[] names = { "Alice", "Bob" };
        Integer[] numbers = { 1, 2, 4 };
        Utility.printArray(names);
        Utility.printArray(numbers);

        // Generic Interface
        Utilisateur user = outerInstance.new Utilisateur();
        UserRepository userRepo = outerInstance.new UserRepository();

        user.setId(0);
        user.setUsername("Djaloud");

        userRepo.save(user);
        System.out.println("\n" + userRepo.findByIndex(0).getUsername());
    }
}
