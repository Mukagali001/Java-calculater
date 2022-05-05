import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

class Matematika {

    public static String intToRoman(int number) throws Exception {


        if (number <= 0) {
            throw new Exception();
        }

        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    private static final NavigableMap<Integer, String> units;

    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();

        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }
}