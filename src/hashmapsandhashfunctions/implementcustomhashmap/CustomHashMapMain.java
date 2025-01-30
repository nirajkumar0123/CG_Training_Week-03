package hashmapsandhashfunctions.implementcustomhashmap;

public class CustomHashMapMain {
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(11, 20);
        map.put(2, 30);

        System.out.println("Value of key 1: " + map.get(1));
        System.out.println("Value of key 2: " + map.get(2));
        System.out.println("Value of key 11: " + map.get(11));

        map.display();

        map.remove(1);
        System.out.println("After removing key 1:");
        map.display();
    }
}

