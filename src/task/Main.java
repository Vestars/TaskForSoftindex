package task;

import java.util.Random;

public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) {
        OpenAddressMyHashMap map = new OpenAddressMyHashMap();

        for(int i = 0; i < map.size(); i++){
            map.put(random.nextInt(25),random.nextInt(50));
        }

        System.out.println("Size: " + map.size());
        System.out.println(map.toString());
    }
}
