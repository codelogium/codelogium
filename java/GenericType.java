public class GenericType {

    // Generic Class
    public class Box<T> {
        private T item;

        public T getItem() { return this.item; }
        public void setItem(T item) { this.item = item; }
    }

    // Generic Method
    public static class Utility {
    public static <T> void printArray(T[] array) {
        for(T element : array) {
            System.out.println(element);
        }
    }
}

    //Main Method
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

        //Generic Method
        String[] names = {"Alice", "Bob"};
        Integer[] numbers = {1, 2, 4};
        Utility.printArray(names);
        Utility.printArray(numbers);

    }
}
