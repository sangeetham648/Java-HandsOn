package collections;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        // Create a HashMap object called people
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        // Add keys and values (Name, Age)
        people.put("John", 32);
        people.put("Steve", 30);
        people.put("Angie", 33);

        System.out.println(people.size());

        for (String i : people.keySet()) {
            System.out.println("key: " + i + " value: " + people.get(i));
        }

        people.remove("John");

        people.put("Angie", 35); // override the value
        System.out.println(people);

        System.out.println(people.keySet()); // Return type is set, because key should be unique  --> Set<String> s = people.keySet();

        System.out.println(people.values()); // Return type is collection --> Collection<Integer> c=people.values();

        System.out.println(people.entrySet()); // Return type is set, because both key and value pair is not repeating -->

        Set<Map.Entry<String,Integer>> sm=people.entrySet();

        for (Map.Entry<String,Integer> i: sm){
            System.out.println(i.getKey());
            System.out.println(i.getValue());
        }

        // LinkedHashMap
        // TreeMap - based on key value asending order



        String s = "wwwaaddddccww"; // w5a2d4c2

        Map<Character, Integer> map = new LinkedHashMap<>(); // w , 1

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (map.containsKey(ch)) {

                int oldValue = map.get(ch);

                map.put(ch, oldValue + 1);

            } else {

                map.put(ch, 1);

            }

        }



        System.out.println(map);

            String input = "wwwaabbww";
            System.out.println(runLengthEncode(input));  // Output: w3a2b2w2


    }
    public static String runLengthEncode(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        result.append(s.charAt(s.length() - 1)).append(count);
        return result.toString();
    }
}
