import java.util.ArrayList;
import java.util.List;

/*
 * Generics are a way to create type-safe and reusable code by allowing you to define type parameters. They help avoid runtime errors, improve readability, and reduce boilerplate code, especially in collections, methods, and custom classes or interfaces.
 */
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
     * it's an interesting and sometimes subtle aspect of Java! Even if you don’t
     * explicitly use the static keyword, any interface declared inside a class is
     * implicitly static by definition.
     * 
     * This means you can reference it without creating an instance of the enclosing
     * class, and it behaves independently of any specific instance of the outer
     * class.
     * 
     * Generics improve type safety and code reusability, ensuring compile-time
     * checks and reducing runtime errors.
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

    // Using E (Element) in a Custom Collection
    /*
     * Adding <E> in the class defintion defines the class as generic.
     * The class can operate on objects of any type specified when the class is
     * instantiated, rather than being tied to a specific type.
     * E is a placeholder for the type you will specify later when using the class.
     * Java needs <E> in the class definition to treat E as a valid type parameter.
     * Otherwise, it assumes E is a class or type that hasn't been defined.
     */
    public class CustomList<E> {
        private List<E> elements = new ArrayList<>();

        public void setElement(E element) {
            this.elements.add(element);
        }

        public E getElement(int index) {
            return this.elements.get(index);
        }
    }

    // Using K (Key) and V (Value) in a Custom Key-Value Pair
    public static class KeyValue<K, V> {
        private K key;
        private V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    // Combining E, K, and V in a Multi-Generic Class
    public static class MultiMap<K, V, E> {
        private E extra;
        private K key;
        private V value;

        public void put(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public E getExtra() {
            return this.extra;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setExtra(E extra) {
            this.extra = extra;
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

        // Generic in Java Collection
        List<String> list = new ArrayList<>();
        list.add("Hello");
        String value = list.get(0); // No Casting needed
        String value2 = (String) list.get(0); // without Generic, it would require casting with exception handling ...
        System.out.println(value);
        System.out.println("\""+ value2 + "\"" + " is printed using String value2 = (String) list.get(0); //Casting before Generics introduced");

        // Using E element in a custom collection
        CustomList<String> customStringList = outerInstance.new CustomList<>();
        customStringList.setElement("Apple");
        customStringList.setElement("Banana");

        CustomList<Integer> customIntegerList = outerInstance.new CustomList<>();
        customIntegerList.setElement(20);
        customIntegerList.setElement(15);
        System.out.println("The price of an " + customStringList.getElement(0) + " is " + customIntegerList.getElement(0) + " while the price of an " + customStringList.getElement(1) + " is " + customIntegerList.getElement(1));

        //Using K, V
        KeyValue<Integer, String> productPriceMapping = new KeyValue<>(38500, "ASUS ProArt 16");
        System.err.println("The Model " + productPriceMapping.getValue() + " cost " + productPriceMapping.getKey() + "MAD");

        KeyValue<String, Integer> ageMapping = new KeyValue<>("Akmal Eddine", 16);
        System.out.println(ageMapping.getKey() + " is " + ageMapping.getValue() + " years old");

        // Combining E, K, and V in a Multi-Generic Class
        MultiMap<String, Integer, String> fruitInfo = new MultiMap<>();
        fruitInfo.put("Banana", 10);
        fruitInfo.setExtra("imported from Morocco");

        System.out.println("The " + fruitInfo.getKey() + " is " + fruitInfo.getValue() + " MAD and is " + fruitInfo.getExtra());


        
    }
}
